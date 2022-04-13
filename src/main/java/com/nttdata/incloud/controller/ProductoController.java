package com.nttdata.incloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.incloud.model.Producto;
import com.nttdata.incloud.rest.framework.CustomRest;
import com.nttdata.incloud.service.ProductoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/Producto")
@CrossOrigin("*")
@Api(tags = "Rest de Producto", description = "Api Rest que permite hacer CRUD a la tabla de Producto.")
public class ProductoController extends CustomRest<ProductoService, Producto> {

	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoService repository;

	@Override
	protected ProductoService createInstance() {
		return this.createInstance();
	}

}
