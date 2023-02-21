package com.moviefy.backend.movie;

import com.moviefy.backend.actor.Actor;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String direction;
    private String scenario;
    private String genre;
    private String production;
    private int premiere;
    private String poster;
    private String moviePhotos;

    @OneToMany
    private List<Actor> actors;
    private String awards;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getPremiere() {
        return premiere;
    }

    public void setPremiere(int premiere) {
        this.premiere = premiere;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getMoviePhotos() {
        return moviePhotos;
    }

    public void setMoviePhotos(String moviePhotos) {
        this.moviePhotos = moviePhotos;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", direction='" + direction + '\'' +
                ", scenario='" + scenario + '\'' +
                ", genre='" + genre + '\'' +
                ", production='" + production + '\'' +
                ", premiere='" + premiere + '\'' +
                ", poster='" + poster + '\'' +
                ", moviePhotos='" + moviePhotos + '\'' +
                ", awards='" + awards + '\'' +
                ", id=" + id +
                '}';
    }
}