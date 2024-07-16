package com.example.practice.services.impl;

import com.example.practice.dtos.coach.CoachDto;
import com.example.practice.entities.Coach;
import com.example.practice.repositories.CoachRepository;
import com.example.practice.services.CoachService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addCoach(CoachDto coach) {
        Coach coachToAdd = modelMapper.map(coach, Coach.class);

        coachRepository.addCoach(coachToAdd);
    }

}