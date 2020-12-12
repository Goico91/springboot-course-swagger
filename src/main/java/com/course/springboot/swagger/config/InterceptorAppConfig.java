package com.course.springboot.swagger.config;

import com.course.springboot.swagger.commons.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorAppConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;

    public InterceptorAppConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(tokenInterceptor).addPathPatterns(Constants.API_EMPLOYEES, Constants.API_EMPLOYEES + Constants.ID);
    }
}
