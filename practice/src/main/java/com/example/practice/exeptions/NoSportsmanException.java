package com.example.practice.exeptions;

public class NoSportsmanException extends  RuntimeException {
    public NoSportsmanException(int id) {
        super("No sportsman found with id: " + id);
    }
}
