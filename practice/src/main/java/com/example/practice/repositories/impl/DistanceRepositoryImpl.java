package com.example.practice.repositories.impl;

import com.example.practice.entities.Distance;
import com.example.practice.repositories.BaseCRRepository;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.DistanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DistanceRepositoryImpl extends BaseCRRepository<Distance, Integer> implements DistanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DistanceRepositoryImpl(Class<Distance> entity) {
        super(entity);
    }

}