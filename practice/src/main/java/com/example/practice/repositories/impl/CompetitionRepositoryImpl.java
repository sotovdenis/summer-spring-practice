package com.example.practice.repositories.impl;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import com.example.practice.repositories.BaseCrudRepo;
import com.example.practice.repositories.CompetitionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CompetitionRepositoryImpl extends BaseCrudRepo<Competition, Integer> implements CompetitionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CompetitionRepositoryImpl(Class<Competition> entity) {
        super(entity);
    }

    @Override
    public Competition findCompetitionById(int id) {
        return entityManager.find(Competition.class, id);
    }

    @Override
    public void addCompetition(Competition competition){
        entityManager.persist(competition);
    }

    @Override
    public CompetitionStatus getCompetitionStatusById(int id) {
        return entityManager.find(Competition.class, id).getCompetitionStatus();
    }
}
