package com.moviefy.backend.user;

import java.util.List;

public class CurrentUser {
    private long id;
    private String email;
    private List<Role> role;

    public CurrentUser(long id, String email, List<Role> role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
