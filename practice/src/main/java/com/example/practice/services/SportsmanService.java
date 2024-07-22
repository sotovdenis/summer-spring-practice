package com.example.practice.services;

import com.example.practice.dtos.*;
import com.example.practice.dtos.sportsman.KickSportsmanDto;
import com.example.practice.dtos.sportsman.NewCategoryDto;
import com.example.practice.dtos.sportsman.SportsmanDto;
import com.example.practice.entities.Queue;

import java.util.List;


public interface SportsmanService {
    void updateSportsmanClubSetNullById(KickSportsmanDto kickSportsmanDto);
    void addSportsman(SportsmanDto sportsman);
    void transferSportsman(TransferDto transferDto);
    void setNewCategory(NewCategoryDto newCategoryDto);
    List<QueueAllDto> makeAQueue(QueueDto queueDto);
}