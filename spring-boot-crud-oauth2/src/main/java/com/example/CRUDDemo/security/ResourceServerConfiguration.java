package com.example.CRUDDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableResourceServer
@ComponentScan(basePackages = "com.example.CRUDDemo.security")
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "my_rest_api";

    @Autowired
    DefaultTokenServices defaultTokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
        resources.tokenServices(defaultTokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        System.out.println("inside user");
        http.authorizeRequests()
                .antMatchers("/user/").access("hasRole('ADMIN')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//        http
//                .antMatcher("/user/")
//                .authorizeRequests().anyRequest().authenticated();
    }


}