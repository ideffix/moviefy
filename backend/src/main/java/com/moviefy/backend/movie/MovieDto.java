package com.moviefy.backend.movie;

import com.moviefy.backend.actor.Actor;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;


public class MovieDto {
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

    public MovieDto(String title, double rating, String director, String scenario, List<Genre> genre,
                    String production, LocalDate premiere, URL poster, List<URL> moviePhotos, List<Actor> actors,
                    List<Awards> awards) {

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
    }


}
