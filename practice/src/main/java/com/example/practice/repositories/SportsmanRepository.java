package com.example.practice.repositories;

import com.example.practice.dtos.QueueAllDto;
import com.example.practice.entities.Queue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanRepository {
    List<QueueAllDto> makeAQueue(String style, int meters);

}