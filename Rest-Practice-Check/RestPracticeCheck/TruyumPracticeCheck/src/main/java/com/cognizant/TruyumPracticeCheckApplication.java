package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cognizant.*"})
public class TruyumPracticeCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumPracticeCheckApplication.class, args);
	}

}
