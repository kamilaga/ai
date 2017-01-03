package com.mas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class MasProjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasProjectServiceApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer html5Mode() {
		return container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
	}
}
