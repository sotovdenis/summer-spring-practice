package com.example.practice.services;

import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;

import java.util.List;

public interface ClubService {

    void addClub(Club club);

//
//    List<Club> findAllByTown(String town);
//
//    Club findAllByCoachId(int id);
//
//    List<Club> findAllByPoints(int points);
//
//    List<Club> findAllById(int id);

    List<Club> findAllByCoachIsNull();

}