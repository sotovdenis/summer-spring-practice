package com.example.practice.repositories;

import com.example.practice.entities.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository {

////    List<Club> findAllByTown(String town);
////    Club findClubByCoachId(int id);
////    List<Club> findAllByPoints(int points);
////    List<Club> findAllById(int id);
//
//    //clubs that need coach
//    @Query(value = "select c from Club c where c.coach is null")
    List<Club> findAllByCoachIsNull();
    void save(Club club);

}
