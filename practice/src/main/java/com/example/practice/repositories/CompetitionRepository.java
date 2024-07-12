package com.example.practice.repositories;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {

    //Competitions that can give new category
    @Query(value = "select c from Competition c where c.competitionStatus = :competitionStatus")
    List<Competition> findAllByCompetitionStatus(@Param(value = "competitionStatus") CompetitionStatus competitionStatus);

}