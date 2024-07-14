package com.example.practice.services.impl;

import com.example.practice.entities.Distance;
import com.example.practice.entities.Style;
import com.example.practice.repositories.DistanceRepository;
import com.example.practice.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService {

    @Autowired
    private DistanceRepository distanceRepository;

    @Override
    public List<Distance> findAllByStyleAndMeters(Style style, int metres) {
        return distanceRepository.findAllByStyleAndMeters(style, metres);
    }

    @Override
    public void addDistance(Distance distance) {
        distanceRepository.addDistance(distance);
    }
}