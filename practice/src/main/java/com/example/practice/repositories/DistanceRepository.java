package com.example.practice.repositories;

import com.example.practice.entities.Distance;
import com.example.practice.entities.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistanceRepository {

    void addDistance(Distance distance);

    //Search for sportsman with his entries
    List<Distance> findAllByStyleAndMeters(Style style, int metres);

}