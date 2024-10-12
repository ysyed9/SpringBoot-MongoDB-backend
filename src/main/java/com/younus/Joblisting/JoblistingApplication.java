package com.younus.Joblisting;  // Root package for the Spring Boot application.

import org.springframework.boot.SpringApplication;  // Provides methods to bootstrap and launch the Spring application.
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Main annotation to enable Spring Boot's auto-configuration and component scanning.
import jakarta.servlet.http.HttpServletResponse;  // Importing HttpServletResponse, though it's unused in this code. Consider removing if not needed.

@SpringBootApplication  // This annotation combines @Configuration, @EnableAutoConfiguration, and @ComponentScan, setting up the Spring context.
public class JoblistingApplication {  // Main class to start the Spring Boot application.

	public static void main(String[] args) {  // Main method, the entry point for the Spring Boot application.
		SpringApplication.run(JoblistingApplication.class, args);  // Starts the Spring application and initializes the Spring context.
	}
}
