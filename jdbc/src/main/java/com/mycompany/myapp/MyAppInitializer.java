package com.mycompany.myapp;

import com.mycompany.myapp.config.Datasourceconfiguration;
import com.mycompany.myapp.config.MyAppConfiguration;
import com.mycompany.myapp.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by aman on 5/9/17.
 */
public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MyAppConfiguration.class, WebSecurityConfig.class, Datasourceconfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
