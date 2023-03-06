package com.moviefy.backend.user;

import com.moviefy.backend.utilityClass.RandomToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class TokenService {
    private HashMap<String , Long> tokenMap = new HashMap<>();
    private final UserRepository userRepository;

    public TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createToken(Long userId) {
        String token = RandomToken.getToken(20);
        tokenMap.put(token, userId);
        return token;
    }

    public UserDTO getUser(String token) {
        Optional<User> user = userRepository.findById(tokenMap.get(token));
        if (user.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return new UserDTO(user.get());
    }
}
