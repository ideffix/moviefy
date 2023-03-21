package com.moviefy.backend.token;

import java.time.LocalDateTime;

public class TokenData {
    private Long id;
    private LocalDateTime time;

    public TokenData(Long id, LocalDateTime time) {
        this.id = id;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
