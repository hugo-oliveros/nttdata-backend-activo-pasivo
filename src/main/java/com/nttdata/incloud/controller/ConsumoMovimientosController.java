package com.nttdata.incloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.incloud.model.ConsumoMovimiento;
import com.nttdata.incloud.rest.framework.CustomRest;
import com.nttdata.incloud.service.ConsumoMovimientoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/ConsumoMovimientoService")
@CrossOrigin("*")
@Api(tags = "Rest de ConsumoMovimientoService", description = "Api Rest que permite hacer CRUD a la tabla de ConsumoMovimientoService.")
public class ConsumoMovimientosController extends CustomRest<ConsumoMovimientoService, ConsumoMovimiento> {

	private static final Logger logger = LoggerFactory.getLogger(ConsumoMovimientosController.class);

	@Autowired
	private ConsumoMovimientoService repository;

	@Override
	protected ConsumoMovimientoService createInstance() {
		return this.createInstance();
	}

}
