package com.example.practice.dtos.coach;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachDto {
    private String surname;
    private String name;
    private String patronymic;
    private int points;
}