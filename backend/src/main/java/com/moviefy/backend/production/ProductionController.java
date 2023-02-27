package com.moviefy.backend.production;

import com.moviefy.backend.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class ProductionController {

    @Autowired
    ProductionRepository productionRepository;

    @PostMapping("/production")
    public Production addProduction(@RequestBody Production production) {
        return productionRepository.save(production);
    }

    @GetMapping("/production")
    public Iterable<Person> getProduction() {
        return productionRepository.findAll();
    }

    @GetMapping("/production/{productionId}")
    public Optional<Person> getProductionById(@PathVariable long productionId) {
        return productionRepository.findById(productionId);
    }
}
