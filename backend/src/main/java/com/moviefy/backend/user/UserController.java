package com.moviefy.backend.user;

import com.moviefy.backend.Email.EmailNotification;
import com.moviefy.backend.filters.CurrentUserHolder;
import com.moviefy.backend.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
    CurrentUserHolder currentUserHolder;

    @PostMapping("/publicusers")
    public User addUser(@RequestBody User user) throws MessagingException {
        UserRegistration.registration(user.getPasswors(), user.getEmail());
        user.setPasswors(UserRegistration.hashPassword(user.getPasswors()));
        String subject = "Potwierdzenie rejestracji";
        String message = "Witaj, Twoja rejestracja na naszej stronie została pomyślnie zakończona.";
        EmailNotification.sendEmail(user.getEmail(), subject, message);
        return userRepository.save(user);
    }

    @GetMapping("/publicusers")
    public List<UserDTO> getUsers() {
        Iterable<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : users) {
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    @GetMapping("publicusers/{userId}")
    public UserDTO getUserById(@PathVariable long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return new UserDTO(user.get());
    }

    @GetMapping("/publicusers/registration/{email}/{password}")
    public String loginUser(@PathVariable String email, @PathVariable String password) throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String hashPassword = UserRegistration.hashPassword(password);
        Optional<User> user = userRepository.findUserByEmailAndPassword(hashPassword, email);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found! Bad email or password!");
        }
        return tokenService.createToken(user.get().getId());
    }

    @GetMapping("/user/me")
    public CurrentUser getMyData() {
        return currentUserHolder.getCurrentUser();
    }

    @GetMapping("/admin/check")
    public String getAdmin() {
        return "Dziala";
    }

    @GetMapping("/user/check")
    public String getUser() {
        return "Dziala";
    }
}
