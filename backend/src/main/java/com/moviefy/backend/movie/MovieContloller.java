package com.moviefy.backend.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MovieContloller {
    @Autowired
    MovieRepository movieRepository;


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
    public List<Movie> getMovieByTitle(@PathVariable String title) {
        return movieRepository.findByTitle(title);
    }
}
