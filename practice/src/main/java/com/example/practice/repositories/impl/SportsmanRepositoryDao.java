package com.example.practice.repositories.impl;

import com.example.practice.entities.*;
import com.example.practice.repositories.SportsmanRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Queue;

@Repository
public class SportsmanRepositoryDao implements SportsmanRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addSportsman(Sportsman sportsman) {
        entityManager.persist(sportsman);
    }

    @Transactional
    public Sportsman findSportsmanById(int id) {
        return entityManager.find(Sportsman.class, id);
    }
}