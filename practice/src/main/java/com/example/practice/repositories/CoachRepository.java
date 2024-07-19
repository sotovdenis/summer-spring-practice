package com.example.practice.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository {
    int findCoachPointsById(int id);
}