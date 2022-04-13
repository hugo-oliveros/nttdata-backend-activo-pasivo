package com.nttdata.incloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.model.ConsumoMovimiento;
import com.nttdata.incloud.repository.ConsumoMovimientosRepository;
import com.nttdata.incloud.service.ConsumoMovimientoService;

@Service
public class ConsumoMovimientoServiceImpl extends GenericServiceImpl<ConsumoMovimiento, Long>
		implements ConsumoMovimientoService {

	@Autowired
	private ConsumoMovimientosRepository repository;

	@Override
	public CrudRepository<ConsumoMovimiento, Long> getDao() {
		return repository;
	}

}