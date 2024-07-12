package com.example.practice.services;

import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;

public interface SportsmanService {

    void deleteSportsmanById(int id);

    void addSportsman(Sportsman sportsman);

    Sportsman findSportsman(int id);

    List<Sportsman> findAllByCategory(Category category);

    List<Sportsman> findAllByEntryTimeAndBirthDate(long entryTime, Date birthDate, Gender gender);


}