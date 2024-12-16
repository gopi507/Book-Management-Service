package com.example.demoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementServiceApplication.class, args);
	}


@Bean
public RestTemplate name() {
	return new RestTemplate();


}}
