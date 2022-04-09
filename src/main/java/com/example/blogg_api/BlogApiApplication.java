package com.example.blogg_api;

import com.example.blogg_api.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	@Bean
	public User user (){
		return new User();
	}

//	@Bean
//	public ModelMapper modelMapper(){
//		return new ModelMapper();
//	}

}
