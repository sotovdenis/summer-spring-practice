package com.example.practice.services;

import com.example.practice.dtos.competition.AddCompetitionDto;
import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;

import java.util.List;

public interface CompetitionService {
    void addCompetition(AddCompetitionDto addCompetitionDto);
}