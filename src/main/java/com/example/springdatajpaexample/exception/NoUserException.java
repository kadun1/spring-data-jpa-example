package com.example.springdatajpaexample.exception;

public class NoUserException extends RuntimeException {

    public NoUserException() {

    }

    public NoUserException(String message) {
        super(message);
        System.out.println("유저가 존재하지 않습니다.");
    }
}
