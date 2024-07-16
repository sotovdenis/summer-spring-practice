package com.example.practice.services.impl;

import com.example.practice.dtos.AddCompetitionDto;
import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import com.example.practice.repositories.CompetitionRepository;
import com.example.practice.services.CompetitionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;
    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public void addCompetition(AddCompetitionDto addCompetitionDto) {
        Competition competition = modelMapper.map(addCompetitionDto, Competition.class);
        competitionRepository.addCompetition(competition);
    }

    @Override
    public List<Competition> findAllByCompetitionStatus(CompetitionStatus competitionStatus) {
        return competitionRepository.findAllByCompetitionStatus(competitionStatus);
    }
}