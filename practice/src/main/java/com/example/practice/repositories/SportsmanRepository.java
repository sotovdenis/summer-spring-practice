package com.example.practice.repositories;

import com.example.practice.entities.Queue;
import com.example.practice.entities.Sportsman;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanRepository {
    List<Queue> makeAQueue(int style, int meters);

}