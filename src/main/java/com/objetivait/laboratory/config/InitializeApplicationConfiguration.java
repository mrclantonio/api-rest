package com.objetivait.laboratory.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import com.objetivait.laboratory.config.filters.ApiOriginFilter;

@Configuration
public class InitializeApplicationConfiguration {
    @Inject
    private ApplicationConfiguration configuration;
    /**
     * Keeps the session open until the end of a request. Allows us to use lazy-loading with Hibernate.
     */
    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }

//    @Bean
//    public ApiOriginFilter apiOriginFilter() {
//        return new ApiOriginFilter();
//    }
}
