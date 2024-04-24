package com.ooadproject.projectmonDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Tells Spring Boot to scan packages in this directory to be able to find entity data and process it
@SpringBootApplication(scanBasePackages = "com.ooadproject.creaturefight")
@EnableAutoConfiguration
public class CreatureFightApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatureFightApplication.class, args);
	}

}
