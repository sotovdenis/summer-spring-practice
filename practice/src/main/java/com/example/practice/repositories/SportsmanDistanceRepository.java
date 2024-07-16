package com.example.practice.repositories;

import com.example.practice.entities.SportsmanDistance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanDistanceRepository {
    List<SportsmanDistance> findAllByResultTimeInMilliseconds(long newTime);
    void addSportsmenDistance(SportsmanDistance sportsmanDistance);
    SportsmanDistance findSportsmanDistanceById(int id);
}