package com.example.practice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueueAllDto {
    private String surname;
    private String name;
    private String patronymic;
    private String town;
    private long entryTime;
    private String style;
}
