package com.example.practice.services;

import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;

import java.util.List;

public interface ClubService {

    void addClub(ClubDto club);

    void addCoach(CoachDto coach, int clubId);

    List<ClubDto> findAllByCoachIsNull();

    int getPointsById(int id);

    void transferCoach(int prevClubId, int nextClubId, int coachId);

}