package com.nttdata.incloud.rest.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.nttdata.incloud.commons.GenericServiceImpl;
import com.nttdata.incloud.repository.ConsumoMovimientosRepository;
import com.nttdata.incloud.repository.PersonaRepository;

@Service
public class JPACustomServiceImpl<T> extends GenericServiceImpl<T, Long> implements JPACustomService<T> {

	//@Autowired
	//private ConsumoMovimientosRepository repository;
	@Autowired
	private PersonaRepository repository;

	@SuppressWarnings("unchecked")
	public CrudRepository<T, Long> getDao() {
		return (CrudRepository<T, Long>) repository;
	}

}
