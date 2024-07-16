package com.example.practice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "distance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Distance extends BaseEntity {
    private Style style;
    private int meters;
    private Competition competition;

    public Distance(Style style, int meters, Competition competition) {
        this.style = style;
        this.meters = meters;
        this.competition = competition;
    }
    protected Distance() {
    }

    @Column(name = "style", nullable = false)
    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Column(name = "meters", nullable = false)
    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id", nullable = false)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
