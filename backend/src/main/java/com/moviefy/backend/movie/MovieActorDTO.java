package com.moviefy.backend.movie;

import com.moviefy.backend.actor.Actor;
import com.moviefy.backend.actor.ActorDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class MovieActorDTO {
    private String title;
    private double rating;
    private String director;
    private String scenario;
    private List<Genre> genre;
    private String production;
    private LocalDate premiere;
    private URL poster;
    private List<URL> moviePhotos;
    private List<Actor> actors;
    private List<Awards> awards;
    private List<ActorDTO> actorDTOS;

    public MovieActorDTO(String title, double rating, String director, String scenario, List<Genre> genre, String production, LocalDate premiere, URL poster, List<URL> moviePhotos, List<Actor> actors, List<Awards> awards, List<ActorDTO> actorDTOS) {
        this.title = title;
        this.rating = rating;
        this.director = director;
        this.scenario = scenario;
        this.genre = genre;
        this.production = production;
        this.premiere = premiere;
        this.poster = poster;
        this.moviePhotos = moviePhotos;
        this.actors = actors;
        this.awards = awards;
        this.actorDTOS = actorDTOS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public LocalDate getPremiere() {
        return premiere;
    }

    public void setPremiere(LocalDate premiere) {
        this.premiere = premiere;
    }

    public URL getPoster() {
        return poster;
    }

    public void setPoster(URL poster) {
        this.poster = poster;
    }

    public List<URL> getMoviePhotos() {
        return moviePhotos;
    }

    public void setMoviePhotos(List<URL> moviePhotos) {
        this.moviePhotos = moviePhotos;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }

    public List<ActorDTO> getActorDTOS() {
        return actorDTOS;
    }

    public void setActorDTOS(List<ActorDTO> actorDTOS) {
        this.actorDTOS = actorDTOS;
    }
}
