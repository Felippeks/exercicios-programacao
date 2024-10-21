package com.m3s04.postit.postit;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Caixa de Sugestões API", version = "1.0"))
public class PostitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostitApplication.class, args);
	}

}
