package com.nttdata.incloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.model.Empresa;
import com.nttdata.incloud.repository.EmpresaRepository;
import com.nttdata.incloud.service.EmpresaService;

 
@Service
public class EmpresaServiceImpl extends GenericServiceImpl<Empresa, Long> implements EmpresaService{
	
	@Autowired
	private EmpresaRepository repository;
	
	@Override
	public CrudRepository<Empresa, Long> getDao() {
		return repository;
	}

	 

}