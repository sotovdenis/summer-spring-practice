package com.example.practice.services;

import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.AddCoachToClubDto;
import com.example.practice.dtos.TransferDto;

import java.util.List;

public interface ClubService {

    void addClub(ClubDto club);

    void addCoachToClub(AddCoachToClubDto addCoachToClubDto);

    List<ClubDto> findAllByCoachIsNull();

    int getPointsById(int id);

    void transferCoach(TransferDto transferDto);

}