package com.example.practice.repositories;

import com.example.practice.entities.Sportsman;
import jakarta.persistence.TemporalType;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SportsmanRepository extends NameRepository<Sportsman> {

    //Search for the sportsman who has overdue category
    @Query(value = "select s from Sportsman s where  s.reachDate > :currentDateMinusTwoYears ")
    List<Sportsman> findAllByReachDateOrderBySurname(@Param(value = "currentDateMinusTwoYears")
                                                     Date date);

    //Search for the sportsman with entry birthday and gender to make a swimming queue
    @Query(value = "select s from Sportsman s "+
    "where s.birthDate = :birthDate and s.gender = :gender")
    List<Sportsman>  findAllByBirthDateAndGender(
            @Param(value = "birthDate") Sportsman birthDate,
            @Param(value = "gender") Sportsman gender);

    List<Sportsman> findAllByReachDate(Date date);
}
