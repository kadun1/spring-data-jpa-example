package com.example.springdatajpaexample.service;

import com.example.springdatajpaexample.config.EMF;
import com.example.springdatajpaexample.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NewUserService {

    public void saveNewUser(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
