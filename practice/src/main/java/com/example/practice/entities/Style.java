package com.example.practice.entities;

public enum Style {

    BUTTERFLY(1),
    BACKSTROKE(2),
    CRAWL(3),
    BREASTSTROKE(4),
    MEDLEY(5);

    private final int index;
    Style (int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
