package com.vivek.learaop;

import com.vivek.learaop.aopexample.BusinessService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearAopApplication implements CommandLineRunner {

	@Autowired
	private BusinessService1 businessService1;

	public static void main(String[] args) {
		SpringApplication.run(LearAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("value returned : " + businessService1.calculateMax());
	}
}
