package com.appConfig.springappConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
//@ComponentScan(basePackages = "com.appConfig")
@EnableAutoConfiguration
public class SpringBootAppConfig {
	
	public static void main(String args[]) {
		 SpringApplication.run(SpringBootAppConfig.class, args);
	}

}
