package com.example.practice.repositories.impl;

import com.example.practice.entities.SportsmanDistance;
import com.example.practice.repositories.BaseCrudRepo;
import com.example.practice.repositories.SportsmanDistanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SportsmanDistanceRepositoryImpl extends BaseCrudRepo<SportsmanDistance, Integer> implements SportsmanDistanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public SportsmanDistanceRepositoryImpl(Class<SportsmanDistance> entity) {
        super(entity);
    }

    @Override
    public void addSportsmenDistance(SportsmanDistance sportsmanDistance) {
        entityManager.persist(sportsmanDistance);
    }

    @Override
    public SportsmanDistance findSportsmanDistanceById(int id) {
        return entityManager.find(SportsmanDistance.class, id);
    }

}