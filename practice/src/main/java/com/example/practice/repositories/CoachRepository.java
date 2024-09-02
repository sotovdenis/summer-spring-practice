package com.example.practice.repositories;

import com.example.practice.entities.Coach;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository {
    int findCoachPointsById(int id);
    void save(Coach coachToAdd);
    Coach findById(Class<Coach> coachClass, int coachId);
}