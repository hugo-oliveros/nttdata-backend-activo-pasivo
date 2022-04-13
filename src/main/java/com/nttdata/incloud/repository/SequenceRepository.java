package com.nttdata.incloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nttdata.incloud.model.Cliente;

public interface SequenceRepository extends MongoRepository<Cliente, Long> {

}
