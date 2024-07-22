package com.example.practice.entities;

public class Queue {
    private Sportsman surname;
    private Sportsman name;
    private Sportsman patronymic;
    private Club town;
    private SportsmanDistance entryTime;
    private Distance style;

    public Queue(Sportsman surname, Sportsman name, Sportsman patronymic, Club town, SportsmanDistance entryTime, Distance style) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.town = town;
        this.entryTime = entryTime;
        this.style = style;
    }

    public Sportsman getSurname() {
        return surname;
    }

    public void setSurname(Sportsman surname) {
        this.surname = surname;
    }

    public Sportsman getName() {
        return name;
    }

    public void setName(Sportsman name) {
        this.name = name;
    }

    public Sportsman getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(Sportsman patronymic) {
        this.patronymic = patronymic;
    }

    public Club getTown() {
        return town;
    }

    public void setTown(Club town) {
        this.town = town;
    }

    public SportsmanDistance getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(SportsmanDistance entryTime) {
        this.entryTime = entryTime;
    }

    public Distance getStyle() {
        return style;
    }

    public void setStyle(Distance style) {
        this.style = style;
    }
}
