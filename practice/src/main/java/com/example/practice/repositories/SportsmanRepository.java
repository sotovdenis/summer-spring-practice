package com.example.practice.repositories;

import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SportsmanRepository {

    void deleteSportsman(int id);
    void addSportsman(Sportsman sportsman);
    Sportsman findSportsmanById(int id);
    List<Sportsman> findAllByCategory(Category category);
    List<Sportsman> findAllByEntryTimeAndBirthDate(long entry, Date birthDate, Gender gender);
    void updateCategoryById(int id, Category category);
    void updateSportsmanClubSetNull(int id);
    long findSportsmanResultTimeById(int id);
    Date findSportsmanReachDateById(int id);
}
