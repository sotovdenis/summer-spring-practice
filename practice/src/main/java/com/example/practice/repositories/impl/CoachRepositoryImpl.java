package com.example.practice.repositories.impl;

import com.example.practice.entities.Coach;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.CoachRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CoachRepositoryImpl extends BaseCRURepository<Coach> implements CoachRepository {

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
}
