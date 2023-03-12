package com.justin.firstspringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstspringprojectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FirstspringprojectApplication.class, args);
	}

}
