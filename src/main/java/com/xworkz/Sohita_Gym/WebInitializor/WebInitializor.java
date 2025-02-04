package com.xworkz.Sohita_Gym.WebInitializor;

import com.xworkz.Sohita_Gym.Configuration.GymConfiguration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializor extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println(" invoking getRootConfigClasses");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("invoking getServletConfigClassess");
        return new Class[] {GymConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("invoking getServletMappings");
        return new String[]{"/"};
    }

}
