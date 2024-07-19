package com.example.practice.repositories.impl;

import com.example.practice.entities.*;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.SportsmanRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SportsmanRepositoryImpl extends BaseCRURepository<Sportsman, Integer> implements SportsmanRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public SportsmanRepositoryImpl(Class<Sportsman> entity) {
        super(entity);
    }

}