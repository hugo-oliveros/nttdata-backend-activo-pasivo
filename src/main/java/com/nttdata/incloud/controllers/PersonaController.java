package com.nttdata.incloud.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.incloud.model.Persona;
import com.nttdata.incloud.rest.framework.CustomRest;
import com.nttdata.incloud.service.PersonaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/Persona")
@CrossOrigin("*")
@Api(tags = "Rest de Persona", description = "Api Rest que permite hacer CRUD a la tabla de Persona.")
public class PersonaController extends CustomRest<PersonaService, Persona> {

	@Override
	protected PersonaService createInstance() {
		return this.createInstance();
	}

}
