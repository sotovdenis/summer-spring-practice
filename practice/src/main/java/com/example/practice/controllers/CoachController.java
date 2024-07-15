package com.example.practice.controllers;

import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Coach;
import com.example.practice.services.CoachService;
import org.modelmapper.ModelMapper;
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
//    @PostMapping("")
//    public void addCoach(CoachDto coach){
//        Coach coachToAdd = modelMapper.map(coach, Coach.class);
//        coachService.addCoach(coachToAdd);
//    }
}
