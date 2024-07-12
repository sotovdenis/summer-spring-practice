package com.example.practice.services.impl;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import com.example.practice.repositories.CompetitionRepository;
import com.example.practice.services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Override
    public List<Competition> findAllByCompetitionStatus(CompetitionStatus competitionStatus) {
        return competitionRepository.findAllByCompetitionStatus(competitionStatus);
    }
}