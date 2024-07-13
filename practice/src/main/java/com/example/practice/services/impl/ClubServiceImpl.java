package com.example.practice.services.impl;

import com.example.practice.entities.Club;
import com.example.practice.repositories.impl.ClubRepositoryDao;
import com.example.practice.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepositoryDao clubRepository;

    @Override
    public void addClub(Club club) {
        clubRepository.save(club);
    }

//    @Override
//    public void deleteClubById(int id) {
//        clubRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Club> findAllByTown(String town) {
//        return clubRepository.findAllByTown(town);
//    }
//
//    @Override
//    public Club findAllByCoachId(int id) {
//        return clubRepository.findClubByCoachId(id);
//    }
//
//    @Override
//    public List<Club> findAllByPoints(int points) {
//        return clubRepository.findAllByPoints(points);
//    }
//
//    @Override
//    public List<Club> findAllById(int id) {
//        return clubRepository.findAllById(id);
//    }

    @Override
    public List<Club> findClubByCoachIsNull() {
        return clubRepository.findClubByCoachIsNull();
    }

}