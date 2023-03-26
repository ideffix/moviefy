package com.moviefy.backend.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;

@Service
public class TokenData implements Serializable {
    private Long id;
    private LocalDateTime time;

    public TokenData(Long id, LocalDateTime time) {
        this.id = id;
        this.time = time;
    }

    public TokenData() {
    }

    @Bean
    @Scope("singleton")
    public TokenData tokenDataSingleton() {
        return new TokenData();
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

    @Override
    public String toString() {
        return "TokenData{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
