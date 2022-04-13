package com.nttdata.incloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.model.Activos;
import com.nttdata.incloud.repository.ActivosRepository;
import com.nttdata.incloud.service.ActivosService;

@Service
public class ActivosServiceImpl extends GenericServiceImpl<Activos, Long> implements ActivosService {

	@Autowired
	private ActivosRepository repository;

	@Override
	public CrudRepository<Activos, Long> getDao() {
		return repository;
	}

}