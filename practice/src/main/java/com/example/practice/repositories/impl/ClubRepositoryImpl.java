package com.example.practice.repositories.impl;

import com.example.practice.entities.Club;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.ClubRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ClubRepositoryImpl extends BaseCRURepository<Club> implements ClubRepository {

    public ClubRepositoryImpl(Class<Club> entity) {
        super(entity);
    }

}
