package com.example.practice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCategoryDto {
    private int sportsmanId;
    private int competitionId;
    private String newCategory;
}