package com.example.practice.services.impl;

import com.example.practice.dtos.distance.AddDistanceDto;
import com.example.practice.entities.Competition;
import com.example.practice.entities.Distance;
import com.example.practice.repositories.CompetitionRepository;
import com.example.practice.repositories.DistanceRepository;
import com.example.practice.services.DistanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainDistanceServiceImpl implements DistanceService {

    @Autowired
    private DistanceRepository distanceRepository;
    @Autowired
    private CompetitionRepository competitionRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addDistance(AddDistanceDto addDistanceDto) {
        Distance distance = modelMapper.map(addDistanceDto, Distance.class);
        Competition competition = competitionRepository.findCompetitionById(addDistanceDto.getCompetitionId());
        distance.setCompetition(competition);

        distanceRepository.addDistance(distance);
    }
}