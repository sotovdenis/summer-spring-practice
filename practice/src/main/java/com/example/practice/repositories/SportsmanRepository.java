package com.example.practice.repositories;

import com.example.practice.entities.Sportsman;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public interface SportsmanRepository {
    void addSportsman(Sportsman sportsman);
    Sportsman findSportsmanById(int id);
}