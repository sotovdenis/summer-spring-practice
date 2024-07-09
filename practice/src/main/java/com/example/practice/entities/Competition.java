package com.example.practice.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Competition extends BaseEntity {
    private Date startDate;
    private Date endDate;
    private String place;
    private String name;
    private CompetitionStatus competitionStatus;

    public Competition(Date startDate, Date endDate, String place, String name, CompetitionStatus competitionStatus) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.name = name;
        this.competitionStatus = competitionStatus;
    }
    protected Competition() {
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "place")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "status")
    public CompetitionStatus getCompetitionStatus() {
        return competitionStatus;
    }

    public void setCompetitionStatus(CompetitionStatus competitionStatus) {
        this.competitionStatus = competitionStatus;
    }
}
