package com.nh.scrum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.nh.scrum.developer", "com.nh.scrum.initializer" })
public class ScrumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrumApplication.class, args);
	}

}
