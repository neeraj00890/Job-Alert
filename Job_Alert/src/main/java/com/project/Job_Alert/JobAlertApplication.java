package com.project.Job_Alert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jobalert.core.CommonUtil;



@ComponentScan(basePackages = {"com.project.*", "com.persistance.*"})
@EntityScan(basePackages = "com.jobalert.entity")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jobalert.repository")
public class JobAlertApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(JobAlertApplication.class);
	    }
	
	public static void main(String[] args) {
		CommonUtil.printMe();
		SpringApplication.run(JobAlertApplication.class, args);
	}
}
