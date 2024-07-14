package com.example.practice.services;

import com.example.practice.entities.Distance;
import com.example.practice.entities.Style;

import java.util.List;

public interface DistanceService {

    List<Distance> findAllByStyleAndMeters(Style style, int metres);
    void addDistance(Distance distance);
}