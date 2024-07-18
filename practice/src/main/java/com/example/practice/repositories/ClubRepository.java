package com.example.practice.repositories;

import com.example.practice.entities.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository {
    void save(Club club);
    Club findClubById(int id);
    void update(Club club);
}