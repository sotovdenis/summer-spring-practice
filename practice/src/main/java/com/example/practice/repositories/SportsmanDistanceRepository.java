package com.example.practice.repositories;

import com.example.practice.entities.SportsmanDistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SportsmanDistanceRepository extends JpaRepository<SportsmanDistance, Integer> {
    //Check for new category for the sportsman
    @Query(value = "select sd from SportsmanDistance sd where sd.resultTimeInMilliseconds < :newCategoryTime")
    List<SportsmanDistance> findAllByResultTimeInMilliseconds(@Param(value = "newCategoryTime") long resultTime);

}