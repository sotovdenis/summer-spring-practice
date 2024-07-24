package com.example.practice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QueueAllDto {
    private String surname;
    private String name;
    private String patronymic;
    private String town;
    private long entryTime;
    private String style;
}
