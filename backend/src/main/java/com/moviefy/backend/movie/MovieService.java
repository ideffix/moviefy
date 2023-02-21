package com.moviefy.backend.movie;

import com.moviefy.backend.actor.Actor;
import com.moviefy.backend.search.Search;

public class MovieService {
    Search search = new Search();

    public void addActor(Movie movie) {
        search.movies.add(movie);
    }

//    public void delethaActor(int id) {
//        search.movies.removeIf(movie -> movie.getId() == id);
//    }
}

