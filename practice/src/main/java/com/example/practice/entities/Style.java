package com.example.practice.entities;

import com.example.practice.exeptions.CoachPointsException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Style {

//    BUTTERFLY,
//    BACKSTROKE,
//    CRAWL,
//    BREASTSTROKE,
//    MEDLEY

    BUTTERFLY(1),
    BACKSTROKE(2),
    CRAWL(3),
    BREASTSTROKE(4),
    MEDLEY(5);

    private final int index;

    Style(int index) {
        this.index = index;
    }

    @JsonValue
    public int getIndex() {
        return index;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static int fromValue(String value) {
        for (Style e : values()) {
            if (String.valueOf(e.index).equals(value)) {
                return e.getIndex();
            }
        }
        throw new CoachPointsException(Style.CRAWL.getIndex());
    }
}
