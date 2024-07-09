package com.example.practice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Sportsman extends Human {
    private Date birthDate;
    private Gender gender;
    private Category category;
    private Date reachDate;
    private Club club;

    public Sportsman(String surname, String name, String patronymic, Date birthDate, Gender gender, Club club) {
        super(surname, name, patronymic);
        this.birthDate = birthDate;
        this.gender = gender;
        this.club = club;
    }

    protected Sportsman() {
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "reach_date")
    public Date getReachDate() {
        return reachDate;
    }

    public void setReachDate(Date reachDate) {
        this.reachDate = reachDate;
    }

    @Column(name = "gender")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
