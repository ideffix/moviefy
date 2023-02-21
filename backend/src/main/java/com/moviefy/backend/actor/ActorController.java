package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @CrossOrigin
    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @CrossOrigin
    @GetMapping("/actor")
    public Iterable<Actor> getActors() {
        return actorRepository.findAll();
    }
}
