package com.example.practice.controllers;

import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Coach;
import com.example.practice.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/clubs/without-coach")
    Iterable<ClubDto> all(){
        return clubService.findAllByCoachIsNull();
    }

    @PostMapping("/add/clubs")
    void createClub(@RequestBody ClubDto newClub){
        clubService.addClub(newClub);
    }

    @PostMapping("/clubs/transfer-coach")
    void transferCoach(@RequestBody int prevClubId, int nextClubId, int coachId){
        clubService.transferCoach(prevClubId, nextClubId, coachId);
    }

    @PostMapping("/clubs/add-coach")
    void addCoach(@RequestBody CoachDto coach, int id){
        clubService.addCoach(coach, id);
    }

}
