package com.example.practice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Style {

    BUTTERFLY(0),
    BACKSTROKE(1),
    CRAWL(2),
    BREASTSTROKE(3),
    MEDLEY(4);

    private final int index;

    Style(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
