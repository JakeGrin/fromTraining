package com.training.sgorodecki.homework.homework22.config.security;

import com.training.sgorodecki.homework.homework22.entity.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/start", "/register", "/error", "/404")
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/consumer", "/order")
                .hasAuthority(UserRole.USER.name())
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginProcessingUrl("/start")
                .loginPage("/start")
                .failureUrl("/start")
                .defaultSuccessUrl("/consumer")
                .permitAll()
                .usernameParameter("login")
                .passwordParameter("password")
                .and()
                .logout().permitAll();
    }
}