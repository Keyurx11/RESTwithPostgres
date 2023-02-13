package com.example.restwithpostgres;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class RestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Student.class);
        config.exposeIdsFor(Course.class);
        config.exposeIdsFor(Degreetype.class);
        config.exposeIdsFor(Coursename.class);
    }
}
