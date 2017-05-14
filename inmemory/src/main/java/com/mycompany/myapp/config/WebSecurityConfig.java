package com.mycompany.myapp.config;

import com.mycompany.myapp.filter.CustomFilter;
import com.mycompany.myapp.security.MyBasicAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by aman on 5/1/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();

        http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
        http.requiresChannel()
                .antMatchers("/api").requiresSecure();

//        http.rememberMe().key("uniqueandSecuret").tokenValiditySeconds(120).rememberMeParameter("remember-me");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("aman").password("abc").roles("ADMIN");
        ;
    }
}