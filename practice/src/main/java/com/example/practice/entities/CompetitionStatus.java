package com.example.practice.entities;

public enum CompetitionStatus {

    REGIONAL(1),
    LOCAL(2),
    DISTRICT(3),
    COUNTRY(4),
    WORLD(5);

    private final int index;
    CompetitionStatus (int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
