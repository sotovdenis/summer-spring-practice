package com.example.practice.exeptions;

public class ClubHasCoachException extends RuntimeException {
    public ClubHasCoachException(int id) {
        super("Club " + id + " already has a coach");
    }
}
