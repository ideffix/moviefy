package com.moviefy.backend.actor;

import com.moviefy.backend.movie.MovieDTO;

import java.time.LocalDate;
import java.util.List;

public class ActorMovieDTO {
    private String firstName;
    private String lastName;
    private String description;
    private LocalDate birthdate;
    private String height;
    private List<MovieDTO> movieDTOS;
}
