package com.example.practice.repositories.impl;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import com.example.practice.repositories.CompetitionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CompetitionRepositoryDao implements CompetitionRepository {

    @Autowired
    private BaseCompetitionRepo baseCompetitionRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Competition> findAllByCompetitionStatus(CompetitionStatus competitionStatus) {
        return baseCompetitionRepo.findAllByCompetitionStatus(competitionStatus);
    }

    @Transactional
    public void addCompetition(Competition competition){
        entityManager.persist(competition);
    }
}

@Repository
interface BaseCompetitionRepo extends JpaRepository<Competition, Integer> {
    @Query(value = "select c from Competition c where c.competitionStatus = :competitionStatus")
    List<Competition> findAllByCompetitionStatus(@Param(value = "competitionStatus") CompetitionStatus competitionStatus);
}