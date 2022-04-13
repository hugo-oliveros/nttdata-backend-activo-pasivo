package com.nttdata.incloud;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() {
		log.info(String.format("\n ********* Init BackEnd Activos/Pasivos *********\n\n"));
	}

}