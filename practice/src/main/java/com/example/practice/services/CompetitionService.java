package com.example.practice.services;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;

import java.util.List;

public interface CompetitionService {

    void addCompetition(Competition competition);

    List<Competition> findAllByCompetitionStatus(CompetitionStatus competitionStatus);

}