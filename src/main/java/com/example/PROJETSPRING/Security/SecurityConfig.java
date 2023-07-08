package com.example.PROJETSPRING.Security;
import com.example.PROJETSPRING.Services.UserDetailsServiceImpl;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;





    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void init(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/clients").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
