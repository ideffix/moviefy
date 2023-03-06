package com.moviefy.backend.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFilterConfig {

    @Bean
    public FilterRegistrationBean<UserFiler> getUserFilter(UserFiler userFiler) {
        FilterRegistrationBean<UserFiler> registration = new FilterRegistrationBean<>();
        registration.setFilter(userFiler);
        registration.addUrlPatterns("/users/me");
        return registration;
    }
}
