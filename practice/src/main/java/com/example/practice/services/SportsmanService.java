package com.example.practice.services;

import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;
import com.example.practice.entities.Style;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;

public interface SportsmanService {

    void deleteSportsmanById(int id);

    void addSportsman(Sportsman sportsman);

    Sportsman findSportsman(int id);

    List<Sportsman> findAllByCategory(Category category);

    List<Sportsman> findAllByEntryTimeAndBirthDate(long entryTime, Date birthDate, Gender gender);

    void updateSportsmanClubSetNull(int id);

    void updateCategoryById(int id, Category category);

    long findSportsmanResultTimeById(int id);

    Date findSportsmanReachDateById(int id);

    List<Sportsman> findAllToMakeAQueue(Style style, int metres);

}