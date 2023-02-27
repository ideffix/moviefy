package com.moviefy.backend.scenario;

import com.moviefy.backend.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ScenarioController{

    @Autowired
    ScenarioRepository scenarioRepository;

    @PostMapping("/scenario")
    public Scenario addProduction(@RequestBody Scenario scenario) {
        return scenarioRepository.save(scenario);
    }

    @GetMapping("/scenario")
    public Iterable<Person> getProduction() {
        return scenarioRepository.findAll();
    }
}
