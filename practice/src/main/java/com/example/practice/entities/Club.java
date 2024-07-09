package com.example.practice.entities;

import jakarta.persistence.*;

@Entity
public class Club extends BaseEntity {
    private String town;
    private Coach coach;
    private int points;

    public Club(String town, Coach coach, int points) {
        this.town = town;
        this.coach = coach;
        this.points = points;
    }

    protected Club() {
    }

    @Column(name = "town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
