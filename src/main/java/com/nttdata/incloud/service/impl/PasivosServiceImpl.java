package com.nttdata.incloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.model.Pasivos;
import com.nttdata.incloud.repository.PasivosRepository;
import com.nttdata.incloud.service.PasivosService;

@Service
public class PasivosServiceImpl extends GenericServiceImpl<Pasivos, Long> implements PasivosService {

	@Autowired
	private PasivosRepository repository;

	@Override
	public CrudRepository<Pasivos, Long> getDao() {
		return repository;
	}

}