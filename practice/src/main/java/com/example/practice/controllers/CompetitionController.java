package com.example.practice.controllers;

import com.example.practice.dtos.competition.AddCompetitionDto;
import com.example.practice.services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @PostMapping("/competition/add")
    void createCompetition(@RequestBody AddCompetitionDto addCompetitionDto) {
        competitionService.addCompetition(addCompetitionDto);
    }

}
