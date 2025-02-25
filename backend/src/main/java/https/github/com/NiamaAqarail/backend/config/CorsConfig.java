package https.github.com.NiamaAqarail.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/voiture/**")
                        .allowedOrigins("http://localhost:4200") // Allow Angular app
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
                registry.addMapping("/client/**")
                        .allowedOrigins("http://localhost:4200") // Allow Angular app
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
                registry.addMapping("/location/**")
                        .allowedOrigins("http://localhost:4200") // Allow Angular app
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
                registry.addMapping("/reparation/**")
                        .allowedOrigins("http://localhost:4200") // Allow Angular app
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");

            }
        };
    }
}