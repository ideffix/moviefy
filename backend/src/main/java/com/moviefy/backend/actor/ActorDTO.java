package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;

import java.time.LocalDate;
import java.util.List;

public class ActorDTO {
    private String firstName;
    private String lastName;
    private String description;
    private LocalDate birthdate;
    private String height;
    private List<Movie> movies;

    public ActorDTO(Actor actor) {
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        this.description = actor.getDescription();
        this.birthdate = actor.getBirthdate();
        this.height = actor.getHeight();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
