package com.example.practice.services.impl;

import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;
import com.example.practice.repositories.SportsmanRepository;
import com.example.practice.services.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DomainSportsmanServiceImpl implements SportsmanService {

    @Autowired
    private SportsmanRepository sportsmanRepository;

    @Override
    public void deleteSportsmanById(int id) {
        sportsmanRepository.deleteById(id);
    }

    @Override
    public void addSportsman(Sportsman sportsman) {
        sportsmanRepository.save(sportsman);
    }

    @Override
    public Sportsman findSportsman(int id) {
        return sportsmanRepository.findSportsmanById(id);
    }

    @Override
    public List<Sportsman> findAllByCategory(Category category) {
        return sportsmanRepository.findAllByCategory(category);
    }

    @Override
    public List<Sportsman> findAllByEntryTimeAndBirthDate(long entryTime, Date birthDate, Gender gender) {
        return sportsmanRepository.findAllByEntryTimeAndBirthDate(entryTime, birthDate, gender);
    }
}