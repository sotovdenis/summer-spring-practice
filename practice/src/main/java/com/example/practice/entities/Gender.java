package com.example.practice.entities;

public enum Gender {

    MALE(1),
    FEMALE(2);

    private final int index;
    Gender (int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
