package com.bowpi.config.web;

import com.bowpi.bean.ResponseWS;
import com.bowpi.config.bean.Catalog;
import com.bowpi.config.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/collection")
public class MongoController {

    @Autowired
    private CatRepository repository;

    @PostMapping("/create/")
    public Catalog createEntity(@RequestBody Catalog catalog){
        return repository.save(catalog);
    }

    @GetMapping("/listAll/")
    public List<Catalog> getAll() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}/")
    public Optional<Catalog> getById(@PathVariable String id){
        return repository.findById(id);
    }

    @PutMapping("/update/{id}/")
    public ResponseWS updateCatalgo(@PathVariable String id, @RequestBody Catalog catalog){
        ResponseWS responseWS = new ResponseWS();
        Optional<Catalog> bowpiCatalogActual = repository.findById(id);

        if(bowpiCatalogActual.isPresent()){
            catalog.setId(id);
            repository.save(catalog);
            responseWS.setCode(1);
            responseWS.setSuccess(true);
            responseWS.setData(catalog);
            return responseWS;
        }else {
            responseWS.setCode(0);
            responseWS.setSuccess(false);
            responseWS.setMessage("Error to update document");
            return responseWS;
        }
    }

    @DeleteMapping("/delete/{id}/")
    public void deleteCatalog(@PathVariable String id){
        repository.deleteById(id);
    }
}
