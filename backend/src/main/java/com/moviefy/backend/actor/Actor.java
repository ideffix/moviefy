package com.moviefy.backend.actor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String birthdate;
    private String height;
//    private List<Movie> moviesThatHePlayedIn = new ArrayList<>();

    public Actor() {
    }

    public Actor(String name, String description, String birthdate, String height /*String moviesThatHePlayedIn*/) {
        this.name = name;
        this.description = description;
        this.birthdate = birthdate;
        this.height = height;
//        this.moviesThatHePlayedIn = moviesThatHePlayedIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

//    public String getMoviesThatHePlayedIn() {
//        return moviesThatHePlayedIn;
//    }
//
//    public void setMoviesThatHePlayedIn(String moviesThatHePlayedIn) {
//        this.moviesThatHePlayedIn = moviesThatHePlayedIn;
//    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", height='" + height + '\'' +
//                ", moviesThatHePlayedIn='" + moviesThatHePlayedIn + '\'' +
                ", id=" + id +
                '}';
    }
}