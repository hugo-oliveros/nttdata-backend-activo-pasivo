package com.nttdata.incloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nttdata.incloud.model.Pasivos;

public interface PasivosRepository extends MongoRepository<Pasivos, Long> {

}
