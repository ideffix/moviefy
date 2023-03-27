package com.moviefy.backend.scenario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends CrudRepository<Scenario, Long> {
}
