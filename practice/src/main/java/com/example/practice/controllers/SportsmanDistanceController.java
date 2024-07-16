package com.example.practice.controllers;

import com.example.practice.dtos.AddSportsmanDistanceDto;
import com.example.practice.dtos.AddSportsmanResultTimeDto;
import com.example.practice.services.SportsmanDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportsmanDistanceController {
    @Autowired
    private SportsmanDistanceService service;

    @PostMapping("/sd/add")
    void createSportsmanDistance(@RequestBody AddSportsmanDistanceDto addSD) {
        service.addSportsmanDistance(addSD);
    }

    @PatchMapping("/sd/add/result")
    void createSportsmanDistance(@RequestBody AddSportsmanResultTimeDto time) {
        service.setResultTime(time);
    }
}
