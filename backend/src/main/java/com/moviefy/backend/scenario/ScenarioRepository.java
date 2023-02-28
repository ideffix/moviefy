package com.moviefy.backend.scenario;

import com.moviefy.backend.person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends CrudRepository<Scenario, Long> {
}
