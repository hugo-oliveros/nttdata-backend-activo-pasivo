package com.nttdata.incloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.incloud.model.Empresa;
import com.nttdata.incloud.rest.framework.CustomRest;
import com.nttdata.incloud.service.EmpresaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/Empresa")
@CrossOrigin("*")
@Api(tags = "Rest de Empresa", description = "Api Rest que permite hacer CRUD a la tabla de Empresa.")
public class EmpresaController extends CustomRest<EmpresaService, Empresa> {

	private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);

	@Override
	protected EmpresaService createInstance() {
		return (EmpresaService) new EmpresaController();
	}

}
