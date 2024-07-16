package com.example.practice.dtos.coach;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCoachToClubDto {
    private int coachId;
    private int clubId;
}