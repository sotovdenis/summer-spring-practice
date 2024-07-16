package com.example.practice.controllers;

import com.example.practice.dtos.coach.CoachDto;
import com.example.practice.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/coach/add")
    void addCoach(@RequestBody CoachDto addCoach){
        coachService.addCoach(addCoach);
    }

}
