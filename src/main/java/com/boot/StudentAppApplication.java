package com.boot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication


public class StudentAppApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}


    @Bean
    ModelMapper getModelMapper()
	{
		ModelMapper obj = new ModelMapper();
		return obj;
	}

}
