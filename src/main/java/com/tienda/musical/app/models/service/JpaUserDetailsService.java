package com.tienda.musical.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.musical.app.models.dao.IPersonaDao;
import com.tienda.musical.app.models.entity.Persona;
import com.tienda.musical.app.models.entity.Rol;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	//un logger para mostrar en consola
    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Autowired
	private IPersonaDao personaDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Persona usuario = personaDao.findByUsuario(username);
		
		if (usuario == null) {
            logger.error("Error login: no existe el usuario '"+ username + "'");
            throw new UsernameNotFoundException("Username "+ username + " no existe en el sistema");
        }
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Rol role: usuario.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getNombre()));
        }
        
        if (authorities.isEmpty()) {
            logger.error("Error login: usuario '"+ username + "' no tiene roles asignados");
            throw new UsernameNotFoundException("Error login: usuario '"+ username + "' no tiene roles asignados");
        }
		
        return new User(usuario.getUsuario(), usuario.getPassword(), usuario.isEstatus(), true, true, true, authorities);
	}
	
}
