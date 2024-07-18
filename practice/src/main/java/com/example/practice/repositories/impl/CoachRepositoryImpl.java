package com.example.practice.repositories.impl;

import com.example.practice.entities.Coach;
import com.example.practice.repositories.BaseCrudRepo;
import com.example.practice.repositories.CoachRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CoachRepositoryImpl extends BaseCrudRepo<Coach, Integer> implements CoachRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CoachRepositoryImpl(Class<Coach> entity) {
        super(entity);
    }

    @Override
    public int findCoachPointsById(int id) {
        Coach coach = entityManager.find(Coach.class, id);
        return coach.getPoints();
    }

    @Override
    public Coach findCoachById(int id) {
        return entityManager.find(Coach.class, id);
    }

    @Transactional
    public void addCoach(Coach coach){
        entityManager.persist(coach);
    }
}