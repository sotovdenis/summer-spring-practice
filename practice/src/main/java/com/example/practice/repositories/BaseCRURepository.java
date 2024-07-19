package com.example.practice.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;



public abstract class BaseCRURepository<E, T> {
    private final Class<E> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseCRURepository(Class<E> entity) {
        this.entityClass  = entity;
    }

    @Transactional
    public void save(E entity) {
        entityManager.persist(entity);
    }

    public E findById(Class<E> entity, int id) {
        return entityManager.find(entity, id);
    }

    @Transactional
    public void update(E entity) {
        entityManager.merge(entity);
    }
}
