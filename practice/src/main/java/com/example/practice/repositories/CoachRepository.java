package com.example.practice.repositories;

import com.example.practice.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {

    List<Coach> findAllByName(String name);
    List<Coach> findAllById(int id);

}
