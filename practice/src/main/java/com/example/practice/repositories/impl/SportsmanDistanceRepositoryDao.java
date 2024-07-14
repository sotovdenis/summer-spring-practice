package com.example.practice.repositories.impl;

import com.example.practice.entities.SportsmanDistance;
import com.example.practice.repositories.SportsmanDistanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SportsmanDistanceRepositoryDao implements SportsmanDistanceRepository {

    @Autowired
    private BaseSportsmanDistanceRepo baseSportsmanDistanceRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SportsmanDistance> findAllByResultTimeInMilliseconds(long newTime) {
        return baseSportsmanDistanceRepo.findAllByResultTimeInMilliseconds(newTime);
    }

    @Transactional
    public void addSportsmanEntryTime(SportsmanDistance sportsmanDistance) {
        entityManager.persist(sportsmanDistance);
    }

    @Transactional
    public void setResultTime(int id, long resultTime) {
        SportsmanDistance sportsmanDistance = entityManager.find(SportsmanDistance.class, id);
        sportsmanDistance.setResultTimeInMilliseconds(resultTime);
    }

}

@Repository
interface BaseSportsmanDistanceRepo extends JpaRepository<SportsmanDistance, Integer> {
    @Query(value = "select sd from SportsmanDistance sd where sd.resultTimeInMilliseconds < :newCategoryTime")
    List<SportsmanDistance> findAllByResultTimeInMilliseconds(@Param(value = "newCategoryTime") long newTime);
}