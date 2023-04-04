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

import java.io.IOException;

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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        tokenService.checkLoginData(token);
        UserDTO userDTO = null;
        try {
            userDTO = tokenService.getUser(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        currentUserHolder.setCurrentUser(new CurrentUser(userDTO.getId(), userDTO.getEmail(), userDTO.getRole()));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
