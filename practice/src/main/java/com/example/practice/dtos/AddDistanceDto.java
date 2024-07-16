package com.example.practice.dtos;

import com.example.practice.entities.Competition;
import com.example.practice.entities.Style;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDistanceDto {
    private String style;
    private int meters;
    private int competitionId;
}
