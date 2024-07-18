package com.example.practice.services.impl;

import com.example.practice.dtos.competition.AddCompetitionDto;
import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import com.example.practice.repositories.CompetitionRepository;
import com.example.practice.repositories.impl.CompetitionRepositoryImpl;
import com.example.practice.services.CompetitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}