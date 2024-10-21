package com.m3s07.m3s07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class M3s07Application {

	public static void main(String[] args) {
		SpringApplication.run(M3s07Application.class, args);
	}

}