package com.ex.natzada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
<<<<<<< HEAD
                    .allowedOrigins("http://localhost:5173")
=======
                    .allowedOrigins("http://localhost:3000", "http://localhost:3001")
>>>>>>> ada3173f40450b623d3fde75de46268eaccc93e7
                    .allowedMethods("*");
            }
        };
    }

}

