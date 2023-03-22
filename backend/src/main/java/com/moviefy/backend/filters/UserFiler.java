package com.moviefy.backend.filters;


import com.moviefy.backend.scenario.ScenarioRepository;
import com.moviefy.backend.token.TokenService;
import com.moviefy.backend.user.CurrentUser;
import com.moviefy.backend.user.UserDTO;
import com.moviefy.backend.user.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class UserFiler implements Filter {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScenarioRepository scenarioRepository;
    @Autowired
    TokenService tokenService;
    @Autowired
    private CurrentUserHolder currentUserHolder;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
//        tokenService.checkLoginData(token);
        UserDTO userDTO = null;
        try {
            userDTO = tokenService.getUser(token);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        currentUserHolder.setCurrentUser(new CurrentUser(userDTO.getId(), userDTO.getEmail(), userDTO.getRole()));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
