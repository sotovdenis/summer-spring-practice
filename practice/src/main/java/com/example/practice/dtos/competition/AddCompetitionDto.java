package com.example.practice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCompetitionDto {
    private long startDate;
    private long endDate;
    private String place;
    private String name;
    private String competitionStatus;
}
