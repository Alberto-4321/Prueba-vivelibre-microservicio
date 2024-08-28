package com.prueba.docker.pruebadocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PruebaDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaDockerApplication.class, args);
	}

}
