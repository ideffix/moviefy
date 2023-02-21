package com.moviefy.backend;

import com.moviefy.backend.Database.DatabaseExample;
import com.moviefy.backend.movie.Movie;
import com.moviefy.backend.movie.MovieRepository;
import com.moviefy.backend.movie.MovieService;
import com.moviefy.backend.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
     	SpringApplication.run(BackendApplication.class, args);
	}

}
