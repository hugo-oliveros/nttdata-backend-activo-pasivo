package com.nttdata.incloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nttdata.incloud.model.Activos;

public interface ActivosRepository extends MongoRepository<Activos, Long> {

}
