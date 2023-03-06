package com.moviefy.backend.user;

import com.moviefy.backend.utilityClass.RandomToken;
import com.moviefy.backend.validators.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenService tokenService;

    @Autowired
    GenericWebApplicationContext context;

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        UserRegistration.registration(user.getPasswors(), user.getEmail());
        user.setPasswors(UserRegistration.hashPassword(user.getPasswors()));
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        Iterable<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : users) {
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    @GetMapping("users/{userId}")
    public UserDTO getUserById(@PathVariable long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return new UserDTO(user.get());
    }

    @GetMapping("/users/registration/{email}/{password}")
    public String loginUser(@PathVariable String email, @PathVariable String password) {
        String hashPassword = UserRegistration.hashPassword(password);
        Optional<User> user = userRepository.findUserByEmailAndPassword(hashPassword, email);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found! Bad email or password!");
        }
        return tokenService.createToken(user.get().getId());
    }

    @GetMapping("/users/me")
    public CurrentUser getMyData() {
        CurrentUser currentUser = context.getBean(CurrentUser.class);
        return currentUser;
    }
}
