package com.example.practice.repositories;

import com.example.practice.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository <Club, Integer> {

    List<Club> findAllByTown(String town);

    //clubs that need coach
    @Query(value = "select c from Club c where c.coach is null")
    List<Club> findClubByCoachIsNull();

    //Clubs that should not dismissal the coach
    @Query(value = "select c from Club c "+
    "join c.coach co where co.points > c.points")
    List<Club> findClubByCoachPoints();
}
