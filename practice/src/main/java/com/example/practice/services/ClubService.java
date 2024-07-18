package com.example.practice.services;

import com.example.practice.dtos.club.ClubDto;
import com.example.practice.dtos.coach.AddCoachToClubDto;
import com.example.practice.dtos.TransferDto;

import java.util.List;

public interface ClubService {
    void addClub(ClubDto club);
    void addCoachToClub(AddCoachToClubDto addCoachToClubDto);
    void transferCoach(TransferDto transferDto);
}