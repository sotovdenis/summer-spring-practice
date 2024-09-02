package com.example.practice.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public abstract class BaseCRRepository<E> {

    private final Class<E> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseCRRepository(Class<E> entity) {
        this.entityClass  = entity;
    }

    @Transactional
    public void save(E entity) {
        entityManager.persist(entity);
    }

    public E findById(Class<E> entity, int id) {
        return entityManager.find(entity, id);
    }
}
