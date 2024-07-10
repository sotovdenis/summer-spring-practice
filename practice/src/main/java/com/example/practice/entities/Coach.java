package com.example.practice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "coach")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
