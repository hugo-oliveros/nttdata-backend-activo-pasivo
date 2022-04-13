package com.nttdata.incloud.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration {

	private final Logger log = LoggerFactory.getLogger(Swagger2UiConfiguration.class);

	@Bean
	public Docket api() {

		log.info("Starting Swagger");

		StopWatch watch = new StopWatch();
		watch.start();

		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.nttdata.incloud.controller")).paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(apiInfo())
				.genericModelSubstitutes(ResponseEntity.class);

		watch.stop();
		log.info("Started Swagger in {} ms", watch.getTotalTimeMillis());
		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("NTTData", "Aplicación de BackEnd", "Backend 1.0", "..", null, "License of API",
				"API license URL", Collections.emptyList());
	}

}
