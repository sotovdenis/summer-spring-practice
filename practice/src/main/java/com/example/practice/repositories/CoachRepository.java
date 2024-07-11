package com.example.practice.repositories;

import com.example.practice.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends NameRepository<Coach> {

    List<Coach> findAllByName(String name);
    List<Coach> findAllById(int id);


    //Coaches who have more points than needed
    @Query(value = "select c from Coach c where c.points > :points")
    List<Coach> findAllByPoints(@Param(value = "points") int points);

}
