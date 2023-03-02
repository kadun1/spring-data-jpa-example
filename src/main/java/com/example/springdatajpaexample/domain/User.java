package com.example.springdatajpaexample.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {


    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_name")
    private String name;

    LocalDateTime createDate;


    public void changeName(String newName) {
        System.out.println(newName);
    }
}
