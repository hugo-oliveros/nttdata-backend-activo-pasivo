package com.nttdata.incloud.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.incloud.model.Cliente;
import com.nttdata.incloud.rest.framework.CustomRest;
import com.nttdata.incloud.service.ClienteService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
@Api(tags = "Rest de Clientes", description = "Api Rest que permite hacer CRUD a la tabla de Clientes.")
public class ClienteController extends CustomRest<ClienteService, Cliente> {

	@Override
	protected ClienteService createInstance() {
		return (ClienteService) new ClienteController();
	}

}
