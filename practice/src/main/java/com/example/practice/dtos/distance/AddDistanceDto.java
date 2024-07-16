package com.example.practice.dtos;

import com.example.practice.entities.Competition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDistanceDto {
    private int style;
    private int meters;
    private int competitionId;
}
