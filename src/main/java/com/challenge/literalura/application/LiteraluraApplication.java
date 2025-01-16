package com.challenge.literalura.application;

import com.challenge.literalura.repository.AutorRepository;
import com.challenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.challenge.literalura.controller.MenuController;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.challenge.literalura")
@EntityScan("com.challenge.literalura.model")
@EnableJpaRepositories("com.challenge.literalura.repository")
public class LiteraluraApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}
}