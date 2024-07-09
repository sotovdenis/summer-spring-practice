package com.example.practice.entities;

import jakarta.persistence.*;

@Entity
public class Distance extends BaseEntity {
    private Style style;
    private int meters;
    private Competition competition;

    protected Distance() {
    }

    public Distance(Style style, int meters, Competition competition) {
        this.style = style;
        this.meters = meters;
        this.competition = competition;
    }

    @Column(name = "style")
    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Basic
    @Column(name = "meters")
    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "competition")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
