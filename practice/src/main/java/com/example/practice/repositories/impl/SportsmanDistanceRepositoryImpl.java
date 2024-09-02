package com.example.practice.repositories.impl;

import com.example.practice.entities.SportsmanDistance;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.SportsmanDistanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class SportsmanDistanceRepositoryImpl extends BaseCRURepository<SportsmanDistance> implements SportsmanDistanceRepository {

    public SportsmanDistanceRepositoryImpl(Class<SportsmanDistance> entity) {
        super(entity);
    }

}