package com.example.practice.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "sportsman_distance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
    @JoinColumn(name = "sportsman_id", referencedColumnName = "id", nullable = false)
    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distance_id", referencedColumnName = "id", nullable = false)
    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    @Column(name = "entry_time", nullable = false)
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
