package com.example.practice.repositories.impl;

import com.example.practice.entities.Distance;
import com.example.practice.repositories.BaseCrudRepo;
import com.example.practice.repositories.DistanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DistanceRepositoryImpl extends BaseCrudRepo<Distance, Integer> implements DistanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DistanceRepositoryImpl(Class<Distance> entity) {
        super(entity);
    }

    @Override
    public void addDistance(Distance distance) {
        entityManager.persist(distance);
    }

    @Override
    public Distance findDistanceById(int id) {
        return entityManager.find(Distance.class, id);
    }
}