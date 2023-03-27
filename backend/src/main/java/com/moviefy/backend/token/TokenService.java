package com.moviefy.backend.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.moviefy.backend.crypto.Base64Impl;
import com.moviefy.backend.crypto.CryptoImpl;
import com.moviefy.backend.user.User;
import com.moviefy.backend.user.UserDTO;
import com.moviefy.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@Service
public class TokenService {
    Base64Impl base64 = new Base64Impl();
    CryptoImpl crypto = new CryptoImpl();

    KeyPair code;
    private static final int TIME_LIMIT_IN_SECONDS = 300;
    private final HashMap<String, TokenData> tokenMap = new HashMap<>();
    private final UserRepository userRepository;

    @Autowired
    TokenData tokenData;

    public TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createToken(Long userId, KeyPair keyPair) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        LocalDateTime loginData = LocalDateTime.now();
        TokenData tokenData = new TokenData(userId, loginData);
        code = keyPair;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String tokenDataJson = objectMapper.writeValueAsString(tokenData);

        String encryptedTokenDataString = base64.encode(tokenDataJson.getBytes(StandardCharsets.UTF_8));

        return encryptedTokenDataString;
    }

    public UserDTO getUser(String token) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IOException, ClassNotFoundException {
        byte[] encryptedTokenData = base64.decode(token);
        String json = new String(encryptedTokenData, StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TokenData tokenDataJson = objectMapper.readValue(json, TokenData.class);

        Optional<User> user = userRepository.findById(tokenDataJson.getId());
        if (user.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return new UserDTO(user.get());
    }

    public void checkLoginData(String token) {
        LocalDateTime actualDateTime = LocalDateTime.now();
        Duration duration = Duration.between(tokenMap.get(token).getTime(), actualDateTime);
        long durationInSeconds = Math.abs(duration.getSeconds());
        if (durationInSeconds > TIME_LIMIT_IN_SECONDS) {
            tokenMap.remove(token);
            throw new RuntimeException("Time has passed");
        }
    }

    public TokenData decodeToken(String tokenString) throws IOException, ClassNotFoundException {
        byte[] byteArray = base64.decode(tokenString);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        TokenData tokenData = (TokenData) objectInputStream.readObject();
        return tokenData;
    }
}
