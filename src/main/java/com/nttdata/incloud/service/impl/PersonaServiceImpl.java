package com.nttdata.incloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.model.Persona;
import com.nttdata.incloud.repository.PersonaRepository;
import com.nttdata.incloud.service.PersonaService;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService {

	@Autowired
	private PersonaRepository repository;

	@Override
	public CrudRepository<Persona, Long> getDao() {
		return repository;
	}

}