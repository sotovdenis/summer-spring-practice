package com.example.practice.services.impl;

import com.example.practice.entities.SportsmanDistance;
import com.example.practice.repositories.SportsmanDistanceRepository;
import com.example.practice.services.SportsmanDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SportsmanDistanceServiceImpl implements SportsmanDistanceService {

    @Autowired
    private SportsmanDistanceRepository sportsmanDistanceRepository;

    @Override
    public List<SportsmanDistance> findAllByResultTimeInMilliseconds(long resultTime) {
        return sportsmanDistanceRepository.findAllByResultTimeInMilliseconds(resultTime);
    }

    @Override
    @Transactional
    public void addSportsmanEntryTime(SportsmanDistance sportsmanDistance) {
        sportsmanDistanceRepository.addSportsmanEntryTime(sportsmanDistance);
    }

    @Override
    public void setResultTime(int id, long resultTime) {
        sportsmanDistanceRepository.setResultTime(id, resultTime);
    }

}