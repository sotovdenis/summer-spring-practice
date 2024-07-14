package com.example.practice.services.impl;

import com.example.practice.entities.Coach;
import com.example.practice.repositories.CoachRepository;
import com.example.practice.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public void addCoach(Coach coach) {
        coachRepository.addCoach(coach);
    }

    @Override
    public int findCoachPointsById(int id) {
        return coachRepository.findCoachPointsById(id);
    }

}