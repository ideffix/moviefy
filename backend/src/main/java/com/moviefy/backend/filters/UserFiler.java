package com.moviefy.backend.filters;


import com.moviefy.backend.scenario.ScenarioRepository;
import com.moviefy.backend.user.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@Component
public class UserFiler implements Filter {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScenarioRepository scenarioRepository;
    @Autowired
    TokenService tokenService;
    @Autowired
    GenericWebApplicationContext context;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        UserDTO userDTO = tokenService.getUser(token);

        context.registerBean(CurrentUser.class, () -> new CurrentUser(userDTO.getId(), userDTO.getEmail(), userDTO.getRole()));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
