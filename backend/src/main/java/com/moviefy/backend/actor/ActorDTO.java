package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;
import com.moviefy.backend.movie.MovieDTO;

import java.time.LocalDate;
import java.util.List;

public class ActorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private LocalDate birthdate;
    private String height;
    private List<MovieDTO> movieDTOS;

    public ActorDTO(Actor actor, List<MovieDTO> movieDTOS) {
        this.id = actor.getId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        this.description = actor.getDescription();
        this.birthdate = actor.getBirthdate();
        this.height = actor.getHeight();
        this.movieDTOS = movieDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<MovieDTO> getMovieDTOS() {
        return movieDTOS;
    }

    public void setMovieDTOS(List<MovieDTO> movieDTOS) {
        this.movieDTOS = movieDTOS;
    }
}
