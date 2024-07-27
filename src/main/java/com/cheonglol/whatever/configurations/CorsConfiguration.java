package com.cheonglol.whatever.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS to all mappings
                .allowedOrigins("http://localhost:3000") // Adjust the origin to match your frontend's origin
                .allowedMethods("*") // Allow all methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Optional: allow credentials
    }
}
