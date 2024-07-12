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
public interface SportsmanRepository extends JpaRepository<Sportsman, Integer> {

    Sportsman findSportsmanById(int id);
    List<Sportsman> findAllByCategory(Category category);

    //Search for the sportsman with entry birthday and gender to make a swimming queue
    @Query(value = "select s from Sportsman s join SportsmanDistance sd where sd.entryTimeInMilliseconds = :entry and s.birthDate = :birthDate and s.gender = :gender")
    List<Sportsman> findAllByEntryTimeAndBirthDate(@Param(value = "entry") long entry,
                                                   @Param(value = "birthDate") Date birthDate,
                                                   @Param(value = "gender") Gender gender);

}
