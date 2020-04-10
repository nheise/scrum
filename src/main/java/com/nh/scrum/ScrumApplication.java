package com.nh.scrum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.nh.scrum.developer" })
@EnableJpaRepositories(basePackages = { "com.nh.scrum.developer" })
public class ScrumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrumApplication.class, args);
	}

}
