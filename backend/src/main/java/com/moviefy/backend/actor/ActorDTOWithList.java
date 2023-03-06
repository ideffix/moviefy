package com.moviefy.backend.actor;

import com.moviefy.backend.movie.MovieDTOWithoutList;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class ActorDTOWithList {
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private LocalDate birthdate;
    private String height;
    private List<MovieDTOWithoutList> movieDTOS;
    private URL profilePhoto;
    private List<URL> photos;


    public ActorDTOWithList(Actor actor, List<MovieDTOWithoutList> movieDTOS) {
        this.id = actor.getId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        this.description = actor.getDescription();
        this.birthdate = actor.getBirthdate();
        this.height = actor.getHeight();
        this.movieDTOS = movieDTOS;
        this.profilePhoto = actor.getProfilePhoto();
        this.photos = actor.getPhotos();

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

    public List<MovieDTOWithoutList> getMovieDTOS() {
        return movieDTOS;
    }

    public void setMovieDTOS(List<MovieDTOWithoutList> movieDTOS) {
        this.movieDTOS = movieDTOS;
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
