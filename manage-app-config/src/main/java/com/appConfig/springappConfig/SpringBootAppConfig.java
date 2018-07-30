package com.appConfig.springappConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan(basePackages = "com.appConfig.")
@EntityScan(basePackages = "com.appConfig.model")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.appConfig.Service")
public class SpringBootAppConfig {
	
	public static void main(String args[]) {
		 SpringApplication.run(SpringBootAppConfig.class, args);
	}

}
