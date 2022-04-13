package com.nttdata.incloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nttdata.incloud.model.Persona;

public interface PersonaRepository extends MongoRepository<Persona, Long> {

}
