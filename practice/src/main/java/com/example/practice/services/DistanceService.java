package com.example.practice.services;

import com.example.practice.dtos.AddDistanceDto;
import com.example.practice.entities.Distance;
import com.example.practice.entities.SportsmanDistance;
import com.example.practice.entities.Style;

import java.util.List;

public interface DistanceService {

    List<Distance> findAllByStyleAndMeters(Style style, int metres);
    void addDistance(AddDistanceDto addDistanceDto);

}