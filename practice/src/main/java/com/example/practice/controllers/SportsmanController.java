package com.example.practice.controllers;

import com.example.practice.dtos.*;
import com.example.practice.dtos.sportsman.KickSportsmanDto;
import com.example.practice.dtos.sportsman.NewCategoryDto;
import com.example.practice.dtos.sportsman.SportsmanDto;
import com.example.practice.services.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    @PostMapping("/sportsman/add")
    void addSportsman(@RequestBody SportsmanDto sportsmanDto) {
        sportsmanService.addSportsman(sportsmanDto);
    }

    @PatchMapping("/sportsman/transfer")
    void transferSportsman(@RequestBody TransferDto transferDto) {
        sportsmanService.transferSportsman(transferDto);
    }

    @PatchMapping("/sportsman/category/set")
    void setNewCategory(@RequestBody NewCategoryDto newCategoryDto) {
        sportsmanService.setNewCategory(newCategoryDto);
    }

    @PatchMapping("/sportsman/kick")
    void updateSportsmanClubById(@RequestBody KickSportsmanDto kickSportsmanDto) {
        sportsmanService.updateSportsmanClubSetNullById(kickSportsmanDto);
    }

}