package com.project.Job_Alert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.project.*")
@EntityScan(basePackages = "com.project.entity")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.Job_Alert.*")
public class JobAlertApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(JobAlertApplication.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(JobAlertApplication.class, args);
	}
}
