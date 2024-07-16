package com.example.practice.dtos.club;

import com.example.practice.entities.Coach;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubDto {
    private String town;
    private int coachId;
    private int points;
}