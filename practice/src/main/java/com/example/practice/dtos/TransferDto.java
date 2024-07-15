package com.example.practice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferDto {
    private int prevClubId;
    private int nextClubId;
    private int id;
}
