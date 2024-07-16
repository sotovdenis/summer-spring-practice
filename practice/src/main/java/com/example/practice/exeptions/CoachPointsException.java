package com.example.practice.exeptions;

public class CoachPointsException extends RuntimeException {
    public CoachPointsException(int id) {
        super("Error occurred Coach points " + id +": not enough points");
    }
}