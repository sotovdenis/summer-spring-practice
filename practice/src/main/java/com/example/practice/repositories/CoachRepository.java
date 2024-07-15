package com.example.practice.repositories;

import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository {

    void addCoach(Coach coach);
    int findCoachPointsById(int id);
    Coach findCoachById(int id);

}