package com.bowpi.manager;

import com.bowpi.config.bean.Catalog;
import com.bowpi.config.repository.CatRepository;

public class BowpiService {
    private final CatRepository catRepository;

    public BowpiService(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public Catalog getByname(String name){
        return catRepository.findByName(name);
    }
}
