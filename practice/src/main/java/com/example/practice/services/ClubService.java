package com.example.practice.services;

import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;

import java.util.List;

public interface ClubService {

    void addClub(Club club);

    List<Club> findAllByCoachIsNull();

}