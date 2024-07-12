package com.example.practice.services;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;

import java.util.List;

public interface CompetitionService {

    List<Competition> findAllByCompetitionStatus(CompetitionStatus competitionStatus);

}