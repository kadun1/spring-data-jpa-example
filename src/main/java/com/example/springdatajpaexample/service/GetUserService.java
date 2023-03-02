package com.example.springdatajpaexample.service;

import com.example.springdatajpaexample.config.EMF;
import com.example.springdatajpaexample.domain.User;
import com.example.springdatajpaexample.exception.NoUserException;
import jakarta.persistence.EntityManager;

public class GetUserService {
    public User getUser(String email) {
        EntityManager em = EMF.createEntityManager();
        try {
            User user = em.find(User.class, email);
            if (user == null) {
                throw new NoUserException("예외발생");
            }
            return user;
        } finally {
            em.close();
        }
    }
}
