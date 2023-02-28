package com.moviefy.backend.production;

import com.moviefy.backend.person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends CrudRepository<Person, Long> {
}
