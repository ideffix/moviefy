package com.moviefy.backend.movie;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m ORDER BY m.rating DESC")
    List<Movie> findTopMovies();
}
