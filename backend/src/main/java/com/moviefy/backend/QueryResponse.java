package com.moviefy.backend;

import com.moviefy.backend.actor.Actor;
import com.moviefy.backend.movie.Movie;
import java.util.ArrayList;
import java.util.List;

public class QueryResponse {
    private List<Movie> movies = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();

    public QueryResponse(List<Movie> movies, List<Actor> actors) {
        this.movies = movies;
        this.actors = actors;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
