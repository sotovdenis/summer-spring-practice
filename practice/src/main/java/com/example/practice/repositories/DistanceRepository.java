package com.example.practice.repositories;

import com.example.practice.entities.Distance;
import com.example.practice.entities.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Integer> {

    //Search for sportsman with his entries
    @Query(value = "select d from Distance d where d.style = :style and d.meters = :metres")
    List<Distance> findAllByStyleAndMeters(@Param(value = "style") Style style,
                                           @Param(value = "metres") int metres);

}