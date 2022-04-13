package com.nttdata.incloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nttdata.incloud.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Long> {

}
