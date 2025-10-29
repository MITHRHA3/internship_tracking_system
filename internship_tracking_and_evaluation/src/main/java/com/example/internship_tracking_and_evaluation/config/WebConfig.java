package com.example.internship_tracking_and_evaluation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/students").setViewName("students/list");
        registry.addViewController("/students/list").setViewName("students/list");
        registry.addViewController("/students/list.html").setViewName("students/list");

        registry.addViewController("/mentors").setViewName("mentors/list");
        registry.addViewController("/internships").setViewName("internships/list");
        registry.addViewController("/evaluations").setViewName("evaluations/list");

        registry.addViewController("/internships/form").setViewName("internships/form");
        registry.addViewController("/evaluations/form").setViewName("evaluations/form");

        registry.addViewController("/login").setViewName("auth/login");
        registry.addViewController("/register").setViewName("auth/register");
    }
}
