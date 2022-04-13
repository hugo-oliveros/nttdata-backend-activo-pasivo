package com.nttdata.incloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nttdata.incloud.model.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, Long> {

}
