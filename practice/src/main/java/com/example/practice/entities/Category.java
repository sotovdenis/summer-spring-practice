package com.example.practice.entities;

public enum Category {

    FIRSTCHILD(1),
    SECONDCHILD(2),
    THIRDCHILD(3),
    FIRSTADULT(4),
    SECONDADULT(5),
    THIRDADULT(6),
    CMS(7),
    MS(8),
    MSIC(9),
    MMS(10);

    private final int index;

    Category (int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}