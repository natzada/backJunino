package com.ex.natzada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FestaJuninaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FestaJuninaApplication.class, args);
	}

}
