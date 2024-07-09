package com.example.practice.entities;

import jakarta.persistence.*;


@Entity
public class SportsmanDistance extends BaseEntity {
    private Sportsman sportsman;
    private Distance distance;
    private long entryTimeInMilliseconds;
    private long resultTimeInMilliseconds;

    public SportsmanDistance(Sportsman sportsman, Distance distance, long entryTimeInMilliseconds, long resultTimeInMilliseconds) {
        this.sportsman = sportsman;
        this.distance = distance;
        this.entryTimeInMilliseconds = entryTimeInMilliseconds;
        this.resultTimeInMilliseconds = resultTimeInMilliseconds;
    }

    protected SportsmanDistance() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "entry_time")
    public long getEntryTimeInMilliseconds() {
        return entryTimeInMilliseconds;
    }

    public void setEntryTimeInMilliseconds(long entryTimeInMilliseconds) {
        this.entryTimeInMilliseconds = entryTimeInMilliseconds;
    }

    @Column(name = "result_time")
    public long getResultTimeInMilliseconds() {
        return resultTimeInMilliseconds;
    }

    public void setResultTimeInMilliseconds(long resultTimeInMilliseconds) {
        this.resultTimeInMilliseconds = resultTimeInMilliseconds;
    }
}
