package com.example.practice.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Coach extends Human {
    private int points;

    public Coach(String surname, String name, String patronymic, int points){
        super(surname, name, patronymic);
        this.points = points;
    }

    protected Coach() {
    }

    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
