package com.example.practice.repositories;

import com.example.practice.entities.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistanceRepository {
    void addDistance(Distance distance);
    Distance findDistanceById(int id);
}