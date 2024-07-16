package com.example.practice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportsmanDto {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private String gender;
    private String category;
    private String reachDate;
    private int clubId;
}
