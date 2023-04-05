package com.vivek.springboot.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class LearnSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringbootApplication.class, args);
	}

}
