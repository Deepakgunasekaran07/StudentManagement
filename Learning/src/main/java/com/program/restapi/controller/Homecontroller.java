package com.program.restapi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Homecontroller {
    @GetMapping("/")
    public String home() {
        return "Welcome to the Student Management API!";
    }
}
