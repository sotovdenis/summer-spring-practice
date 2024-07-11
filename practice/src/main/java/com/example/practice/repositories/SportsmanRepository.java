package com.example.practice.repositories;

import com.example.practice.entities.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SportsmanRepository extends JpaRepository<Sportsman, Integer> {

    //Search for the sportsman with entry birthday and gender to make a swimming queue
    @Query(value = "select s from Sportsman s "+
    "where s.birthDate = :bithDate and s.gender = :gender")
    List<Sportsman>  findAllByBirthDateAndGender(
            @Param(value = "birtDate") Sportsman birthDate,
            @Param(value = "gender") Sportsman gender);

    List<Sportsman> findAllByReachDateOrderBySurname(Date date);
}
