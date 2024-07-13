package com.example.practice.repositories.impl;

import com.example.practice.entities.Club;
import com.example.practice.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubRepositoryDao implements ClubRepository {
    @Autowired
    private BaseClubRepo baseClubRepo;

    @Override
    public List<Club> findClubByCoachIsNull() {
        return baseClubRepo.findAllByCoachIsNull();
    }

    public void save(Club club) {
        baseClubRepo.save(club);
    }
}

@Repository
interface BaseClubRepo extends JpaRepository<Club, Integer>{
    @Query(value = "select c from Club c where c.coach is null")
    List<Club> findAllByCoachIsNull();
}