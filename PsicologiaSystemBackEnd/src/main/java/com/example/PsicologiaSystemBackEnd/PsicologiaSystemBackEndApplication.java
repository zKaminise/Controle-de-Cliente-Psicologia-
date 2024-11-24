package com.example.PsicologiaSystemBackEnd;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Controle de Clientes",
				description = "API Responsável pelo controle de Clientes",
				version = "1"
		)
)
public class PsicologiaSystemBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsicologiaSystemBackEndApplication.class, args);
	}
}
