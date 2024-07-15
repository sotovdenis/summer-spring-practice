package com.example.practice.services.impl;

import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;
import com.example.practice.entities.Style;
import com.example.practice.repositories.DistanceRepository;
import com.example.practice.repositories.SportsmanDistanceRepository;
import com.example.practice.repositories.SportsmanRepository;
import com.example.practice.services.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DomainSportsmanServiceImpl implements SportsmanService {

    @Autowired
    private SportsmanRepository sportsmanRepository;

    @Override
    public void deleteSportsmanById(int id) {
        sportsmanRepository.deleteSportsman(id);
    }

    @Override
    public void addSportsman(Sportsman sportsman) {
        sportsmanRepository.addSportsman(sportsman);
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

    @Override
    public void updateSportsmanClubSetNull(int id) {
        sportsmanRepository.updateSportsmanClubSetNull(id);
    }

    @Override
    public void updateCategoryById(int id, Category category) {
        sportsmanRepository.updateCategoryById(id, category);
    }

    @Override
    public long findSportsmanResultTimeById(int id) {
        return sportsmanRepository.findSportsmanResultTimeById(id);
    }

    @Override
    public Date findSportsmanReachDateById(int id) {
        return sportsmanRepository.findSportsmanReachDateById(id);
    }

    @Override
    public List<Sportsman> findAllToMakeAQueue(Style style, int metres) {
        return sportsmanRepository.findAllToMakeAQueue(style, metres);
    }
}