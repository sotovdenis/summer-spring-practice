package com.example.practice.repositories;

import com.example.practice.entities.SportsmanDistance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanDistanceRepository {
    SportsmanDistance findById(Class<SportsmanDistance> sportsmanDistanceClass, int sdId);
    void update(SportsmanDistance sd);
    void save(SportsmanDistance sd);
}