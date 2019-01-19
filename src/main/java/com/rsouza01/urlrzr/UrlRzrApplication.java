package com.rsouza01.urlrzr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.rsouza01.urlrzr.repository")
public class UrlRzrApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlRzrApplication.class, args);
	}

}

