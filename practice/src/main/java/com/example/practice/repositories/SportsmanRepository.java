package com.example.practice.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanRepository {
    List<Object[]> makeAQueue(String style, int meters);

}