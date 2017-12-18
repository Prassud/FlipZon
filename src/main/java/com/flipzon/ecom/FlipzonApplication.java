package com.flipzon.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlipzonApplication {

	public static void main(String[] args) {
		System.out.println("Flipzon Application Running......");
		SpringApplication.run(FlipzonApplication.class, args);
	}
}
