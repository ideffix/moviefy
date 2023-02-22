package com.moviefy.backend.movie;

import com.moviefy.backend.actor.Actor;
import jakarta.persistence.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String director;
    private String scenario;
    @ElementCollection(targetClass = Genre.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<Genre> genre;
    private String production;
    private int premiere;
    private URL poster;
    @ElementCollection
    private List<URL> moviePhotos;
    @OneToMany
    private List<Actor> actors;
    @ElementCollection(targetClass = Awards.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<Awards> awards;
    @OneToMany
    List<Rating> ratings = new ArrayList<>();

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    //    public int getRatings() {
//        int suma = 0;
//        int dlugosc = 0;
//        for (Rating rating : ratings) {
//            suma += rating.getRating();
//            dlugosc++;
//        }
//        return suma/dlugosc;
//    }

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

    public int getPremiere() {
        return premiere;
    }

    public void setPremiere(int premiere) {
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

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + ratings +
                ", direction='" + director + '\'' +
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