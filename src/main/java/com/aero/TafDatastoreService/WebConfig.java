package com.aero.TafDatastoreService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")  // Allow all endpoints
                    .allowedOrigins("http://localhost:3000")  // Replace with the origin of your frontend (the URL of your frontend app)
                    .allowedMethods("GET", "POST", "PUT", "DELETE")  // You can customize allowed methods
                    .allowedHeaders("*")  // Allow all headers
                    .allowCredentials(true);  // If you need to send cookies or credentials
        }
    }


