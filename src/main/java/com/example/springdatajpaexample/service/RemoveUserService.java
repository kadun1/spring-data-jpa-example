package com.example.springdatajpaexample.service;

import com.example.springdatajpaexample.config.EMF;
import com.example.springdatajpaexample.domain.User;
import com.example.springdatajpaexample.exception.NoUserException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RemoveUserService {
    public void removeUser(String email) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User user = em.find(User.class, email);
            if (user == null) {
                throw new NoUserException();
            }
            em.remove(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
