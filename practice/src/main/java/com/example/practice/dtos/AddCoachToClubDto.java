package com.example.practice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCoachToClubDto {
    private int coachId;
    private int clubId;
}
