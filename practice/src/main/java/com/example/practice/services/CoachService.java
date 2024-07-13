package com.example.practice.services;

import com.example.practice.entities.Coach;

import java.util.List;

public interface CoachService {

    void addCoach(Coach coach);

    List<Coach> findAllByName(String name);

    List<Coach> findAllById(int id);

}