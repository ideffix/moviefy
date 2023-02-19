package com.moviefy.backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class AppController {

    @Value("${app.version}")
    private String version;

    @Value("${app.name}")
    private String name;

    @GetMapping("/name")
    public String getAppName() {
        return name;
    }

    @GetMapping("/version")
    public String getVersion() {
        return version;
    }

}
