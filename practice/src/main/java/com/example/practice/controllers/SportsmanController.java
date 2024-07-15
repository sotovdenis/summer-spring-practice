package com.example.practice.controllers;

import com.example.practice.dtos.QueueDto;
import com.example.practice.dtos.SportsmanDto;
import com.example.practice.dtos.TransferDto;
import com.example.practice.entities.Style;
import com.example.practice.mappers.StringToStyleMapper;
import com.example.practice.services.SportsmanService;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    @PostMapping("/sportsman/add")
    void addSportsman(@RequestBody SportsmanDto sportsmanDto){
        sportsmanService.addSportsman(sportsmanDto);
    }

    @GetMapping("/sportsman/queue")
    @ResponseBody
    Iterable<SportsmanDto> makeAQueue(@RequestParam(required = false) String style, @RequestParam(required = false) int meters) {
        return sportsmanService.findAllToMakeAQueue(style, meters);
    }

    @PatchMapping("/sportsman/transfer")
    void transferSportsman(@RequestBody TransferDto transferDto) {
        sportsmanService.transferSportsman(transferDto);
    }
}

//{
//        "surname": "Sotov",
//        "name": "Denis",
//        "patronymic": "Ruslanovich",
//        "birthDate": "1231231",
//        "gender": "MALE",
//        "category": "CMS",
//        "reachDate": "12312312",
//        "clubId": 1
//        }