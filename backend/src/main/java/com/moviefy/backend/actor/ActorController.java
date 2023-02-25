package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;
import com.moviefy.backend.movie.MovieDto;
import com.moviefy.backend.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
////    }

    @GetMapping("/actor/byid/{actorId}")
    public Optional serchActorById(@PathVariable long actorId) {
        return actorRepository.findById(actorId);
    }
//
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
