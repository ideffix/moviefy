package com.moviefy.backend.actor;

import com.moviefy.backend.movie.Movie;
import jakarta.persistence.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private LocalDate birthdate;
    private String height;
    @ManyToMany
    private List<Movie> movies;
    private URL profilePhoto;
    @ElementCollection
    private List<URL> photos;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public URL getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(URL profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public List<URL> getPhotos() {
        return photos;
    }

    public void setPhotos(List<URL> photos) {
        this.photos = photos;
    }
}