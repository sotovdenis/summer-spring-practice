package com.example.practice.repositories.impl;

import com.example.practice.entities.Distance;
import com.example.practice.entities.Style;
import com.example.practice.repositories.DistanceRepository;
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
public class DistanceRepositoryDao implements DistanceRepository {

    @Autowired
    private BaseDistanceRepo baseDistanceRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addDistance(Distance distance) {
        entityManager.persist(distance);
    }

    @Override
    public List<Distance> findAllByStyleAndMeters(Style style, int metres) {
        return baseDistanceRepo.findAllByStyleAndMeters(style, metres);
    }
}

@Repository
interface BaseDistanceRepo extends JpaRepository<Distance, Integer> {
    @Query(value = "select d from Distance d where d.style = :style and d.meters = :metres")
    List<Distance> findAllByStyleAndMeters(@Param(value = "style") Style style,
                                           @Param(value = "metres") int metres);
}
