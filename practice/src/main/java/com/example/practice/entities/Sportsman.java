package com.example.practice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sportsman")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    @Column(name = "birth_date", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "category", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "reach_date", nullable = false)
    public Date getReachDate() {
        return reachDate;
    }

    public void setReachDate(Date reachDate) {
        this.reachDate = reachDate;
    }

    @Column(name = "gender", nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", referencedColumnName = "id", nullable = false)
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
