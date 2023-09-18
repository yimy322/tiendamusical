package com.tienda.musical.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.tienda.musical.app.auth.handler.LoginSuccessHandler;
import com.tienda.musical.app.models.service.JpaUserDetailsService;

@EnableMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig {

	//para el mensaje de usuario logeado
    @Autowired
    private LoginSuccessHandler successHanler;
    
    @Autowired
    private JpaUserDetailsService userDetailsService ;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http.authorizeHttpRequests((authz) -> {
            try {
                authz.requestMatchers(mvc.pattern("/"),
                		mvc.pattern("/css/**"),
                		mvc.pattern("/img/**"),
                		mvc.pattern("/registro/**"),
                        mvc.pattern("/js/**")).permitAll()
                        .anyRequest().authenticated();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).formLogin(form -> form.loginPage("/login").permitAll().successHandler(successHanler))
        .logout((logout) -> logout.permitAll());

        return http.build();

    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder);
    }
    
}
