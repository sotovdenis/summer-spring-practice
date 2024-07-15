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
    private ModelMapper modelMapper = new ModelMapper();

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
    public Club findClubByID(int id) {
        return entityManager.find(Club.class, id);
    }

    @Override
    public void addCoach(Coach coach, int clubId) {
        Club club = entityManager.find(Club.class, clubId);
        ClubDto clubDto = modelMapper.map(club, ClubDto.class);
        Coach coachDto = modelMapper.map(coach, Coach.class);
        clubDto.setCoach(coachDto);
    }

}

@Repository
interface BaseClubRepo extends JpaRepository<Club, Integer> {
    @Query(value = "select c from Club c where c.coach is null")
    List<Club> findAllByCoachIsNull();
}