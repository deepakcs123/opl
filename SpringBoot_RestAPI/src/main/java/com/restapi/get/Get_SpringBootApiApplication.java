package com.restapi.get;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restapi.SpringBootRestApiApplication;

@SpringBootApplication
public class Get_SpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
		System.out.println("Hello");
	}

}
