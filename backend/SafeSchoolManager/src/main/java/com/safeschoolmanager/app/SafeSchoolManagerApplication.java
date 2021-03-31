package com.safeschoolmanager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SafeSchoolManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeSchoolManagerApplication.class, args);
	}

	// the bean configuration for CORS
	@Bean
	public WebMvcConfigurer configure() {

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
			}
		};

	}

}
