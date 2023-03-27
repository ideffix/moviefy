package com.moviefy.backend.scenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ScenarioController {

    @Autowired
    ScenarioRepository scenarioRepository;

    @PostMapping("/scenario")
    public Scenario addProduction(@RequestBody Scenario scenario) {
        return scenarioRepository.save(scenario);
    }

    @GetMapping("/scenario")
    public List<ScenarioDTO> getProduction() {
        Iterable<Scenario> scenarios = scenarioRepository.findAll();
        List<ScenarioDTO> scenarioDTOList = new ArrayList<>();
        for (Scenario scenario : scenarios) {
            scenarioDTOList.add(new ScenarioDTO(scenario));
        }
        return scenarioDTOList;
    }
}
