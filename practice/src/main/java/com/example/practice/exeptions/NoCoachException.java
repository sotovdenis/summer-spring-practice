package com.example.practice.exeptions;

public class NoCoachException extends RuntimeException {
    public NoCoachException(int id) {
        super("No coach found with id: " + id);
    }
}