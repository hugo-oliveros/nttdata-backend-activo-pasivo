package com.nttdata.incloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.incloud.dto.ActivosRequestDTO;
import com.nttdata.incloud.model.Activos;
import com.nttdata.incloud.rest.framework.CustomRest;
import com.nttdata.incloud.service.ActivosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/Activos")
@CrossOrigin("*")
@Api(tags = "Rest de Activos", description = "Api Rest que permite hacer CRUD a la tabla de Activos.")
public class ActivosController extends CustomRest<ActivosService, Activos> {

	private static final Logger logger = LoggerFactory.getLogger(ActivosController.class);

	@Autowired
	private ActivosService repository;

	@Override
	protected ActivosService createInstance() {
		return this.createInstance();
	}

	@GetMapping("/Personal/{id}")
	@ApiOperation(value = "Personal: solo se permite un solo crédito por persona.", produces = "application/json")
	public ActivosRequestDTO Personal(@PathVariable("id") Long id) {
		logger.info("Ingresando a Personal");
		ActivosRequestDTO activosMaxMov = new ActivosRequestDTO();
		return activosMaxMov;
	}

	@GetMapping("/Empresarial/{id}")
	@ApiOperation(value = "Empresarial: se permite más de un crédito por empresa.", produces = "application/json")
	public ActivosRequestDTO Empresarial(@PathVariable("id") Long id) {
		logger.info("Ingresando a Empresarial");
		ActivosRequestDTO activosMaxMov = new ActivosRequestDTO();
		return activosMaxMov;
	}

	@GetMapping("/TarjetaCrePeEmpre/{id}")
	@ApiOperation(value = "Tarjeta de Crédito personal o empresarial.", produces = "application/json")
	public ActivosRequestDTO TarjetaCrePeEmpre(@PathVariable("id") Long id) {
		logger.info("Ingresando a TarjetaCrePeEmpre");
		ActivosRequestDTO activosMaxMov = new ActivosRequestDTO();
		return activosMaxMov;
	}
}
