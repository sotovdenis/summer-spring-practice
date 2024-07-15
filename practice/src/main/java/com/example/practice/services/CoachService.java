package com.example.practice.services;

import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Coach;

import java.util.List;

public interface CoachService {

    void addCoach(CoachDto coach);

    int findCoachPointsById(int id);

}