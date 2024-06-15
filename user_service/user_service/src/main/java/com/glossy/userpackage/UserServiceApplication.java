package com.glossy.userpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	//todo : see if we need to always have a @Bean or @service for it to be autowired?
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
