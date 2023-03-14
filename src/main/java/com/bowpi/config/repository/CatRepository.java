package com.bowpi.config.repository;

import com.bowpi.config.bean.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatRepository extends MongoRepository<Catalog, String> {
    Catalog findByName(String name);
}
