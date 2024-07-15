package com.example.practice.repositories;

import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository {

    List<Club> findAllByCoachIsNull();
    void save(Club club);
    int getPointsById(int id);
    Club findClubByID(int id);
    void addCoach(Coach coach, int clubId);
}