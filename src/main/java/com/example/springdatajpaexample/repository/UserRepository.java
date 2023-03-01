package com.example.springdatajpaexample.repository;

import com.example.springdatajpaexample.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, String> {
    Optional<User> findById(String email);

    List<User> findByName(String name);

    List<User> findByIdAndName(String email, String name);

    List<User> findByNameLike(String keyword);

    List<User> findByCreateDateAfter(LocalDateTime time);

    List<User> findByCreateDateBetween(LocalDateTime from, LocalDateTime to);

    List<User> findAll();

    void delete(User user);

    User save(User user);

    List<User> findByNameLike(String keyword, Pageable pageable);

    User findAllByCreateDate();
}
