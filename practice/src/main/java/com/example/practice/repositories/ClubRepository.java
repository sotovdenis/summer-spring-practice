package com.example.practice.repositories;

import com.example.practice.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository <Club, Integer> {
    List<Club> findAllByTown(String town);
}
