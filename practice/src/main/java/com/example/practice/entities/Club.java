package com.example.practice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "club")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @Column(name = "town", nullable = false)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coach_id", referencedColumnName = "id")
    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
