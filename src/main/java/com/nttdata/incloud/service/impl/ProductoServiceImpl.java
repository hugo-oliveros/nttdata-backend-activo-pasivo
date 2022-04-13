package com.nttdata.incloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.model.Producto;
import com.nttdata.incloud.repository.ProductoRepository;
import com.nttdata.incloud.service.ProductoService;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public CrudRepository<Producto, Long> getDao() {
		return repository;
	}

}