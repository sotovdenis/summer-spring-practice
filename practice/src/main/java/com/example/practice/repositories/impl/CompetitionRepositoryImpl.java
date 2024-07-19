package com.example.practice.repositories.impl;

import com.example.practice.entities.Competition;
import com.example.practice.entities.CompetitionStatus;
import com.example.practice.repositories.BaseCRRepository;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.CompetitionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CompetitionRepositoryImpl extends BaseCRRepository<Competition, Integer> implements CompetitionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CompetitionRepositoryImpl(Class<Competition> entity) {
        super(entity);
    }

    @Override
    public CompetitionStatus getCompetitionStatusById(int id) {
        return entityManager.find(Competition.class, id).getCompetitionStatus();
    }
}
