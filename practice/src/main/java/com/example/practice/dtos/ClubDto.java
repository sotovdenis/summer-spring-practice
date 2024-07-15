package com.example.practice.dtos;

import com.example.practice.entities.Coach;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubDto {
    private String town;
    private CoachDto coachId;
    private int points;
}
