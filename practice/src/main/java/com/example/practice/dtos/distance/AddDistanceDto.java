package com.example.practice.dtos.distance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDistanceDto {
    private String style;
    private int meters;
    private int competitionId;
}