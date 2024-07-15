package com.example.practice.controllers;

import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.AddCoachToClubDto;
import com.example.practice.dtos.TransferDto;
import com.example.practice.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/clubs/without-coach")
    Iterable<ClubDto> clubsWhereCoachIsNull() {
        return clubService.findAllByCoachIsNull();
    }

    @PostMapping("/clubs/add")
    void createClub(@RequestBody ClubDto newClub) {
        clubService.addClub(newClub);
    }

    @PatchMapping("/clubs/transfer")
    void transferCoach(@RequestBody TransferDto transferDto) {
        clubService.transferCoach(transferDto);
    }

    @PatchMapping("/clubs/add-coach")
    void addCoachToClub(@RequestBody AddCoachToClubDto addCoachToClubDto) {
        clubService.addCoachToClub(addCoachToClubDto);
    }


}