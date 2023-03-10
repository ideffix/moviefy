package com.moviefy.backend.movie;

import com.moviefy.backend.actor.Actor;
import jakarta.persistence.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class MovieDTO {
    private String title;
    private String director;
    private String scenario;
    private List<Genre> genre;
    private String production;
    private LocalDate premiere;
    private URL poster;
    private List<URL> moviePhotos;
    private List<Awards> awards;

    public MovieDTO(String title, String director, String scenario, List<Genre> genre,
                    String production, LocalDate premiere, URL poster, List<URL> moviePhotos, List<Awards> awards) {
        this.title = title;
        this.director = director;
        this.scenario = scenario;
        this.genre = genre;
        this.production = production;
        this.premiere = premiere;
        this.poster = poster;
        this.moviePhotos = moviePhotos;
        this.awards = awards;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }
}
