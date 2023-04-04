package com.moviefy.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.moviefy.backend.crypto.CryptoImpl;
import com.moviefy.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

@Configuration
public class SecurityConfig {

    CryptoImpl crypto = new CryptoImpl();

    @Bean
    @Scope("singleton")
    public KeyPair getKeys() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        return crypto.createKeys(secret);
    }

    @Value("${app.security.secret}")
    String secret;
    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }


}
