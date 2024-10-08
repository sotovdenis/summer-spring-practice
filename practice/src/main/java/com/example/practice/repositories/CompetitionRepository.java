package com.example.practice.repositories;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository {
    CompetitionStatus getCompetitionStatusById(int id);
    void save(Competition competition);
    Competition findById(Class<Competition> competitionClass, int competitionId);
}