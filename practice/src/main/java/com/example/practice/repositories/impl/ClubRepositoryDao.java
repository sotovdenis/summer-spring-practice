package com.example.practice.repositories.impl;

import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;
import com.example.practice.repositories.ClubRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClubRepositoryDao implements ClubRepository {

    @Autowired
    private BaseClubRepo baseClubRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Club> findAllByCoachIsNull() {
        return baseClubRepo.findAllByCoachIsNull();
    }

    @Transactional
    public void save(Club club) {
        entityManager.persist(club);
    }

    @Transactional
    public int getPointsById(int id) {
        Club club = entityManager.find(Club.class, id);
        return club.getPoints();
    }

    @Override
    @Transactional
    public Club findClubById(int id) {
        return entityManager.find(Club.class, id);
    }

//    @Override
//    public void updateCoach(int clubId, int coachId) {
//        Club club = entityManager.find(Club.class, clubId);
//        Coach coach = entityManager.find(Coach.class, coachId);
//        club.setCoach(coach);
//    }

}

@Repository
interface BaseClubRepo extends JpaRepository<Club, Integer> {
    @Query(value = "select c from Club c where c.coach is null")
    List<Club> findAllByCoachIsNull();
}