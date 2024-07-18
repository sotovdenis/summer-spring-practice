package com.example.practice.services;

import com.example.practice.dtos.sportsman.AddSportsmanDistanceDto;
import com.example.practice.dtos.sportsman.AddSportsmanResultTimeDto;
import com.example.practice.entities.SportsmanDistance;

import java.util.List;

public interface SportsmanDistanceService {
//    List<SportsmanDistance> findAllByResultTimeInMilliseconds(long resultTime);
    void setResultTime(AddSportsmanResultTimeDto addSportsmanResultTimeDto);
    void addSportsmanDistance(AddSportsmanDistanceDto addSportsmanDistanceDto);
}