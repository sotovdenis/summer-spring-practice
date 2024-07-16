package com.example.practice.repositories;

import com.example.practice.entities.Sportsman;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanRepository {

    void addSportsman(Sportsman sportsman);

    Sportsman findSportsmanById(int id);

    List<Sportsman> findAllToMakeAQueue(String style, int meters);
}