package com.example.practice.dtos.sportsman;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSportsmanDistanceDto {
    private int sportsmanId;
    private int distanceId;
    private long entryTimeInMilliseconds;
    private long resultTimeInMilliseconds;
}