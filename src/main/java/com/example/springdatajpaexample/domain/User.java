package com.example.springdatajpaexample.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    LocalDateTime createDate;

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_name")
    private String name;

}
