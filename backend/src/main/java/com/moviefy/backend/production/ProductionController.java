package com.moviefy.backend.production;

import com.moviefy.backend.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
    public List<ProductionDTO> getProduction() {
        Iterable<Person> productions = productionRepository.findAll();
        List<ProductionDTO> productionDTOList = new ArrayList<>();
        for (Person production : productions) {
            productionDTOList.add(new ProductionDTO(production));
        }
        return productionDTOList;
    }

    @GetMapping("/production/{productionId}")
    public ProductionDTO getProductionById(@PathVariable long productionId) {
        Optional<Person> production = productionRepository.findById(productionId);
        if (production.isEmpty()) {
            throw new RuntimeException("Production not found!");
        }
        return new ProductionDTO(production.get());
    }
}
