package com.example.practice.services;

import com.example.practice.dtos.*;
import com.example.practice.dtos.sportsman.KickSportsmanDto;
import com.example.practice.dtos.sportsman.NewCategoryDto;
import com.example.practice.dtos.sportsman.SportsmanDto;


public interface SportsmanService {
    void updateSportsmanClubSetNullById(KickSportsmanDto kickSportsmanDto);
    void addSportsman(SportsmanDto sportsman);
    void transferSportsman(TransferDto transferDto);
    void setNewCategory(NewCategoryDto newCategoryDto);
}