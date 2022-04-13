package com.nttdata.incloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.model.Cliente;
import com.nttdata.incloud.repository.ClienteRepository;
import com.nttdata.incloud.service.ClienteService;

 
@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public CrudRepository<Cliente, Long> getDao() {
		return repository;
	}

	 

}