package com.moviefy.backend.search;

import com.moviefy.backend.actor.Actor;
import com.moviefy.backend.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public List<Actor> actors = new ArrayList<>();
    public List<Movie> movies = new ArrayList<>();

    public Actor searchActorByName(String name) {
        for (Actor actor : actors) {
            if (actor.getFirstName().equals(name) || actor.getLastName().equals(name)) {
                return actor;
            }
        }
        throw new RuntimeException("");
    }

    public Actor searchActorById(int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        throw new RuntimeException("");
    }

    public Movie searchMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        throw new RuntimeException("");
    }

//    public Movie searchMovieById(int id) {
//        for (Movie movie : movies) {
//            if (movie.getId() == id) {
//                return movie;
//            }
//        }
//        throw new RuntimeException("");
//    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
