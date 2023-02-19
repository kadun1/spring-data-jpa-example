package com.example.springdatajpaexample.service;

import com.example.springdatajpaexample.domain.User;

public interface UserService {
    User findUser(String email);
}
