package com.example.practice.repositories;

import com.example.practice.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository <Coach, Integer> {
}
