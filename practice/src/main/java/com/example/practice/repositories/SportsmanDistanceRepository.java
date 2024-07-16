package com.example.practice.repositories;

import com.example.practice.dtos.AddSportsmanDistanceDto;
import com.example.practice.entities.SportsmanDistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SportsmanDistanceRepository {
    //Check for new category for the sportsman
    List<SportsmanDistance> findAllByResultTimeInMilliseconds(long newTime);

    void setResultTime(int id, long resultTime);

    void addSportsmenDistance(SportsmanDistance sportsmanDistance);

    SportsmanDistance findSportsmanDistanceById(int id);

}