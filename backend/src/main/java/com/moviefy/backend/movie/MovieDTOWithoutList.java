package com.moviefy.backend.movie;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class MovieDTOWithoutList {
    private Long id;
    private String title;
    private int rating;
    private String director;
    private String scenario;
    private List<Genre> genre;
    private String production;
    private LocalDate premiere;
    private URL poster;
    private List<URL> moviePhotos;
    private List<Awards> awards;

    public MovieDTOWithoutList(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.rating = movie.getRating();
        this.director = movie.getDirector();
        this.scenario = movie.getScenario();
        this.genre = movie.getGenre();
        this.production = movie.getProduction();
        this.premiere = movie.getPremiere();
        this.poster = movie.getPoster();
        this.moviePhotos = movie.getMoviePhotos();
        this.awards = movie.getAwards();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
