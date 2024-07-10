package com.example.practice.repositories;

import com.example.practice.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository <Club, Integer> {
}
