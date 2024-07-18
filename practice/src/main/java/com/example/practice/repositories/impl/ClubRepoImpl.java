package com.example.practice.repositories.impl;

import com.example.practice.entities.Club;
import com.example.practice.repositories.BaseCrudRepo;
import com.example.practice.repositories.ClubRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClubRepoImpl extends BaseCrudRepo<Club, Integer> implements ClubRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ClubRepoImpl(Class<Club> entity) {
        super(entity);
    }

    @Transactional
    public void save(Club club) {
        entityManager.persist(club);
    }

    @Transactional
    public void update(Club club) {
        Club updatedClub = entityManager.merge(club);
        entityManager.persist(updatedClub);
    }

    @Transactional
    public Club findClubById(int id) {
        return entityManager.find(Club.class, id);
    }
}
