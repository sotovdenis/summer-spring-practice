package com.example.practice.services.impl;

import com.example.practice.entities.Club;
import com.example.practice.repositories.ClubRepository;
import com.example.practice.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public void addClub(Club club) {
        clubRepository.save(club);
    }

    @Override
    public List<Club> findAllByCoachIsNull() {
        return clubRepository.findAllByCoachIsNull();
    }

}