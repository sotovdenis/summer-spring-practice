package com.example.practice.controllers;

import com.example.practice.dtos.distance.AddDistanceDto;
import com.example.practice.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    @PostMapping("/distance/add")
    void createCompetition(@RequestBody AddDistanceDto addDistanceDto) {
        distanceService.addDistance(addDistanceDto);
    }

}
