package com.example.springdatajpaexample.service;

import com.example.springdatajpaexample.domain.User;
import com.example.springdatajpaexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public User findUser(String email) {
        Optional<User> userOpt = userRepository.findById("kadun@gmail.com");
        userOpt.ifPresent(user -> {
            userRepository.delete(user);
        });

        LocalDateTime createDate = LocalDateTime.now();

        User savedUser = userRepository.save(new User(createDate,"kadun@gmail.com", "희나리"));

        return savedUser;
    }
}
