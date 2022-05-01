package com.aws.opensearch.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HealthCheckController {

    @GetMapping("/")
    public String health() {
        return "Hello & Welcome to LRC POC !!!";
    }
}
