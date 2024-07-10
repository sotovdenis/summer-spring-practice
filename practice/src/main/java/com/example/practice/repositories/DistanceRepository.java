package com.example.practice.repositories;

import com.example.practice.entities.Distance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistanceRepository extends JpaRepository<Distance, Integer> {
}
