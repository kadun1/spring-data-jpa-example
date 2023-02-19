package com.example.springdatajpaexample.controller;

import com.example.springdatajpaexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/save/{email}")
    public String saveUser(@PathVariable String email) {

        userService.findUser(email);

        return "success";
    }
}
