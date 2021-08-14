package com.boaentrega.informacoescadastrais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableResourceServer
public class InformacoesCadastraisApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformacoesCadastraisApplication.class, args);
	}

}