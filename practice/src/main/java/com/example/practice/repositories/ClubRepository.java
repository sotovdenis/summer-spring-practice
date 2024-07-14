package com.example.practice.repositories;

import com.example.practice.entities.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository {

    List<Club> findAllByCoachIsNull();
    void save(Club club);
    int getPointsById(int id);

}
