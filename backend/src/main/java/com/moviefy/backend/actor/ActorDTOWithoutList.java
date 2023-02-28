package com.moviefy.backend.actor;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class ActorDTOWithoutList {
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private LocalDate birthdate;
    private String height;
    private URL profilePhoto;
    private List<URL> photos;

    public ActorDTOWithoutList(Actor actor) {
        this.id = actor.getId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        this.description = actor.getDescription();
        this.birthdate = actor.getBirthdate();
        this.height = actor.getHeight();
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
