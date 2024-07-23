package com.example.practice.controllers;

import com.example.practice.dtos.QueueAllDto;
import com.example.practice.dtos.QueueDto;
import com.example.practice.dtos.club.ClubDto;
import com.example.practice.dtos.competition.AddCompetitionDto;
import com.example.practice.services.CompetitionService;
import com.example.practice.services.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private SportsmanService sportsmanService;

    @PostMapping("/competition/add")
    void createCompetition(@RequestBody AddCompetitionDto addCompetitionDto) {
        competitionService.addCompetition(addCompetitionDto);
    }

    @GetMapping("/competition/queue")
    Iterable<QueueAllDto> makeAQueue(@RequestParam(required = false) String style, @RequestParam(required = false) int meters) {
        QueueDto queueDto = new QueueDto(style, meters);
        return sportsmanService.makeAQueue(queueDto);
    }

//    @GetMapping("/competition/queue")
//    Iterable<CreateQueueDto> makeAQueue(@RequestParam(required = false) int style, @RequestParam(required = false) int meters) {
////        http://localhost:8080/sportsman/queue?style=CRAWL&meters=50
//        QueueDto queueDto = new QueueDto(style, meters);
//        return sportsmanService.findAllToMakeAQueue(queueDto);
//    }

}
