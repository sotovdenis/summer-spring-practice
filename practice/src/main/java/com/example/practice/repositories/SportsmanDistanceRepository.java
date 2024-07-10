package com.example.practice.repositories;

import com.example.practice.entities.SportsmanDistance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsmanDistanceRepository extends JpaRepository<SportsmanDistance, Integer> {
}
