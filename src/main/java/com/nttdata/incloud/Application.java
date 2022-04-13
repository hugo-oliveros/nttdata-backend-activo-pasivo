package com.nttdata.incloud;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() {
		log.info(String.format("\nNTTDATA \n ********* Init BackEnd Activos/Pasivos *********\n\n"));
	}

}