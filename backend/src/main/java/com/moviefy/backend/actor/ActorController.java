package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;
import com.moviefy.backend.movie.MovieDTO;
import com.moviefy.backend.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ActorController {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin
    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @CrossOrigin
    @GetMapping("/actor")
    public List<ActorDTO> getActors() {
        Iterable<Actor> actors = actorRepository.findAll();
        Iterable<Movie> movies = movieRepository.findAll();
        List<ActorDTO> actorDTOS = new ArrayList<>();
        for (Actor actor : actors) {
            List<MovieDTO> movieDTOS = new ArrayList<>();
            for (Movie movie : movies) {
                for (Actor actor1 : movie.getActors()) {
                    if (actor.getId() == actor1.getId()) {
                        MovieDTO movieDTO = new MovieDTO(movie);
                        movieDTOS.add(movieDTO);
                    }
                }
            }
            actorDTOS.add(new ActorDTO(actor, movieDTOS));
         }
        return actorDTOS;
    }

    @GetMapping("/actor/byname/{actorName}")
    public List<Actor> searchActorByName(@PathVariable String actorName) {
        Iterable<Actor> actors = actorRepository.findAll();
        List<Actor> actorList = new ArrayList<>();
        for (Actor actor : actors) {
            if (actor.getFirstName().toLowerCase().contains(actorName.toLowerCase()) ||
                    actor.getLastName().toLowerCase().contains(actorName.toLowerCase())) {
                actorList.add(actor);
            }
        }
        return actorList;
    }
    @GetMapping("/actor/{actorId}")
    public ActorDTO searchActorById(@PathVariable long actorId) {
        Iterable<Actor> actors = actorRepository.findAll();
        List<MovieDTO> movieDTO = new ArrayList<>();
        for (Actor actor : actors) {
            if (actor.getId() == actorId) {
                for (Movie movie : movieRepository.findAll()) {
                    for (Actor actor1 : movie.getActors()) {
                        if (actor1.getId() == actorId) {
                            movieDTO.add(new MovieDTO(movie));
                        }
                    }
                }
                return new ActorDTO(actor, movieDTO);
            }
        }
        throw new RuntimeException("Actor not found!");
    }
}