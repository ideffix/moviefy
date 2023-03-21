package com.moviefy.backend.token;

import com.moviefy.backend.user.User;
import com.moviefy.backend.user.UserDTO;
import com.moviefy.backend.user.UserRepository;
import com.moviefy.backend.utilityClass.RandomToken;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@Service
public class TokenService {

    private static final int TIME_LIMIT_IN_SECONDS = 300;
    private final HashMap<String, TokenData> tokenMap = new HashMap<>();
    private final UserRepository userRepository;

    public TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createToken(Long userId) {
        LocalDateTime loginData = LocalDateTime.now();
        String token = RandomToken.getToken(20);
        TokenData tokenData = new TokenData(userId, loginData);
        tokenMap.put(token, tokenData);
        return token;
    }

    public UserDTO getUser(String token) {
        Optional<User> user = userRepository.findById(tokenMap.get(token).getId());
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
}
