package com.moviefy.backend.movie;

import com.moviefy.backend.QueryResponse;
import com.moviefy.backend.actor.Actor;
import com.moviefy.backend.actor.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping
public class MovieController {
    @Autowired
    MovieRepository movieRepository;
    @Autowired 
    ActorRepository actorRepository;


    @CrossOrigin
    @GetMapping("/movies")
    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/movie/{id}")
    public Optional<Movie> getUserById(@PathVariable Long id) {
        return movieRepository.findById(id);
    }

    @CrossOrigin
    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @CrossOrigin
    @GetMapping("/movie/title/{title}")
    public QueryResponse getMovieByTitle(@PathVariable String title) {
        Iterable<Movie> iterableMovie = movieRepository.findAll();
        Iterable<Actor> iterableActor = actorRepository.findAll();
        List<Movie> movies = new ArrayList<>();
        List<Actor> actors = new ArrayList<>();
        iterableMovie.forEach(movies::add);
        iterableActor.forEach(actors::add);
        List<Movie> movieFound = new ArrayList<>();
        List<Actor> actorFound = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getTitle().toUpperCase(Locale.ROOT).contains(title.toUpperCase())) {
                movieFound.add(movie);
            }
        }
        for (Actor actor : actors) {
            if (actor.getName().toUpperCase(Locale.ROOT).contains(title.toUpperCase())) {
                actorFound.add(actor);
            }
        }
        return new QueryResponse(movieFound, actorFound);
    }
}
