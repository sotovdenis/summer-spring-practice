package com.example.practice.repositories.impl;

import com.example.practice.entities.*;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.SportsmanRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SportsmanRepositoryImpl extends BaseCRURepository<Sportsman, Integer> implements SportsmanRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public SportsmanRepositoryImpl(Class<Sportsman> entity) {
        super(entity);
    }

    @Override
    public List<Queue> makeAQueue(int style, int meters) {
        return entityManager.createQuery("select s.surname, s.name, s.patronymic, cl.town, sd.entryTimeInMilliseconds, d.style from Sportsman s "+
                "join SportsmanDistance sd on s.id = sd.sportsman.id "+
                "join Distance d on sd.distance.id = d.id "+
                "left join Club  cl on s.club.id = cl.id "+
                "where d.style = :style and d.meters = :meters", Queue.class)
                .setParameter("style", style)
                .setParameter("meters", meters)
                .getResultList();
    }
}