package com.example.practice.repositories;

import com.example.practice.entities.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsmanRepository extends JpaRepository<Sportsman, Integer> {
}
