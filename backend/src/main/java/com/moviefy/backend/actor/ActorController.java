package com.moviefy.backend.actor;

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
    MovieRepository movieRepository;

    @CrossOrigin
    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @CrossOrigin
    @GetMapping("/actor")
    public List<ActorDTO> getActors() {
        Iterable<Actor> actors = actorRepository.findAll();
        List<ActorDTO> actorDTOS = new ArrayList<>();
        for (Actor iterable : actors) {
            actorDTOS.add(new ActorDTO(iterable));
        }
        return actorDTOS;
    }

    @GetMapping("/actor/byid/{actorId}")
    public ActorDTO serchActorById(@PathVariable long actorId) {
        Optional<Actor> actor = actorRepository.findById(actorId);
        if (actor.isEmpty()) {
            throw new RuntimeException("Actor not found!");
        }
        ActorDTO actorDTO = new ActorDTO(actor.get());
        return actorDTO;
    }

////    @PutMapping("/actor/{actorId}/{movieId}")
////    public void addMovieToActor(@PathVariable long movieId, @PathVariable long actorId) {
////        Optional<Movie> movie = movieRepository.findById(movieId);
////        Optional<Actor> actor = actorRepository.findById(actorId);
////        if (movie.isEmpty() || actor.isEmpty()) {
////            throw  new RuntimeException("Movie or actor not found!");
////        }
////        MovieDto movieDto = new MovieDto(movie.get().getTitle(), movie.get().getRating(), movie.get().getDirector(),
////                movie.get().getScenario(), movie.get().getGenre(), movie.get().getProduction(), movie.get().getPremiere(),
////                movie.get().getPoster(), movie.get().getMoviePhotos(), movie.get().getActors(), movie.get().getAwards());
////
////        movie.get().getActors().add(actor.get());
////        actor.get().getMovies().add(movieDto);
////        movieRepository.save(movie.get());
////    }

}
