package com.example.practice.entities;

import jakarta.persistence.*;

@MappedSuperclass
@Table(name = "human")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Human extends BaseEntity {
    private String surname;
    private String name;
    private String patronymic;

    protected Human() {
    }

    public Human(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
