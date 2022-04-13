package com.nttdata.incloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nttdata.incloud.model.ConsumoMovimiento;

public interface ConsumoMovimientosRepository extends MongoRepository<ConsumoMovimiento, Long> {

}
