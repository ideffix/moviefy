package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;
import com.moviefy.backend.movie.MovieDTOWithoutList;
import com.moviefy.backend.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<ActorDTOWithList> getActors() {
        Iterable<Actor> actors = actorRepository.findAll();
        Iterable<Movie> movies = movieRepository.findAll();
        List<ActorDTOWithList> actorDTOS = new ArrayList<>();
        for (Actor actor : actors) {
            List<MovieDTOWithoutList> movieDTOS = new ArrayList<>();
            for (Movie movie : movies) {
                for (Actor actor1 : movie.getActors()) {
                    if (actor.getId() == actor1.getId()) {
                        MovieDTOWithoutList movieDTO = new MovieDTOWithoutList(movie);
                        movieDTOS.add(movieDTO);
                    }
                }
            }
            actorDTOS.add(new ActorDTOWithList(actor, movieDTOS));
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
    public ActorDTOWithList searchActorById(@PathVariable long actorId) {
        Optional<Actor> actor = actorRepository.findById(actorId);
        List<MovieDTOWithoutList> movieDTO = new ArrayList<>();

        for (Movie movie : actor.get().getMovies()) {
            movieDTO.add(new MovieDTOWithoutList(movie));
        }

        return new ActorDTOWithList(actor.orElseThrow(() -> new RuntimeException("Actor not found!")), movieDTO);
    }
}