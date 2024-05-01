package com.ooadproject.projectmonDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Tells Spring Boot to scan packages in this directory to be able to find entity data and process it
@SpringBootApplication(scanBasePackages = "com.ooadproject.projectmonDB")
//@EnableAutoConfiguration -- automatically added
@EnableTransactionManagement
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

}
