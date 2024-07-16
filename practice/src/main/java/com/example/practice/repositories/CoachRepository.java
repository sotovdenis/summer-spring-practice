package com.example.practice.repositories;

import com.example.practice.entities.Coach;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository {
    void addCoach(Coach coach);
    int findCoachPointsById(int id);
    Coach findCoachById(int id);
}