package com.example.practice.services;

import com.example.practice.entities.SportsmanDistance;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SportsmanDistanceService {

    List<SportsmanDistance> findAllByResultTimeInMilliseconds(long resultTime);

    void addSportsmanEntryTime(SportsmanDistance sportsmanDistance);

    void setResultTime(int id, long resultTime);
}