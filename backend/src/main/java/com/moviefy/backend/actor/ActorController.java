package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

//    @GetMapping("/actor/byname/{actorName}")
//    public List<Actor> serchActorByName(@PathVariable String actorName) {
//        Iterable<Actor> actors = actorRepository.findAll();
//        List<Actor> actorList = new ArrayList<>();
//        for (Actor actor : actors) {
//            if (actor.getFirstName().toLowerCase().contains(actorName.toLowerCase()) ||
//                    actor.getLastName().toLowerCase().contains(actorName.toLowerCase())) {
//                actorList.add(actor);
//            }
//        }
//        return actorList;
//    }
    @GetMapping("/actor/byid/{actorId}")
    public Actor serchActorById(@PathVariable int actorId) {
        Iterable<Actor> actors = actorRepository.findAll();
        for (Actor actor : actors) {
            if (actor.getId() == actorId) {
                return actor;
            }
        }
        throw new RuntimeException("Actor not found!");
    }

}
