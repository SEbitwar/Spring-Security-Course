package com.goudscode.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.goudscode.security.ApplicationUserRoles.ADMIN;
import static com.goudscode.security.ApplicationUserRoles.STUDENT;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    public final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index","/").permitAll()
                .antMatchers("/admin/**").hasRole(ADMIN.name())
                .antMatchers("/student/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails sainath = User.builder()
                .username("Sainath")
                .password(passwordEncoder.encode("Sainath"))
                .roles(ADMIN.name())
                .build();

        UserDetails swati = User.builder()
                .username("swati")
                .password(passwordEncoder.encode("swati123"))
                .roles(STUDENT.name())
                .build();

        return  new InMemoryUserDetailsManager(sainath, swati);
    }
}
