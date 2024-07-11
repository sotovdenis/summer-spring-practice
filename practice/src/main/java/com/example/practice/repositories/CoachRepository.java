package com.example.practice.repositories;

import com.example.practice.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository <Coach, Integer> {

    List<Coach> findAllByName(String name);

    //Coaches who have more points than needed
    @Query(value = "select c from Coach c where c.points > :points")
    List<Coach> findAllByPoints(@Param(value = "points") Coach points);

}
