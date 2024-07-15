package com.example.practice.services.impl;

import com.example.practice.dtos.SportsmanDto;
import com.example.practice.dtos.TransferDto;
import com.example.practice.entities.*;
import com.example.practice.exeptions.ClubHasCoachException;
import com.example.practice.exeptions.CoachPointsException;
import com.example.practice.exeptions.NoCoachException;
import com.example.practice.mappers.StringToStyleMapper;
import com.example.practice.repositories.ClubRepository;
import com.example.practice.repositories.SportsmanRepository;
import com.example.practice.services.ClubService;
import com.example.practice.services.SportsmanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainSportsmanServiceImpl implements SportsmanService {

    @Autowired
    private SportsmanRepository sportsmanRepository;

    @Autowired
    private ClubRepository clubRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void deleteSportsmanById(int id) {
        sportsmanRepository.deleteSportsman(id);
    }

    @Override
    public void addSportsman(SportsmanDto sportsmanDto) {
        Sportsman sportsmanToAdd = modelMapper.map(sportsmanDto, Sportsman.class);

        Club club = clubRepository.findClubById(sportsmanDto.getClubId());
        sportsmanToAdd.setClub(club);

        sportsmanRepository.addSportsman(sportsmanToAdd);

    }

    @Override
    public List<SportsmanDto> findAllToMakeAQueue(String style, int meters) {
        return sportsmanRepository.findAllToMakeAQueue(style, meters)
                .stream()
                .map(s -> modelMapper.map(s, SportsmanDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void transferSportsman(TransferDto transferDto) {

        int prevClubId = transferDto.getPrevClubId();
        int nextClubId = transferDto.getNextClubId();
        int sportsmanId = transferDto.getId();


        if (sportsmanRepository.findSportsmanById(sportsmanId) == null) {
            throw new NoCoachException(sportsmanId);
        }

        if (clubRepository.findClubById(nextClubId).getCoach() != null) {
            throw new ClubHasCoachException(nextClubId);
        }


        clubRepository.findClubById(prevClubId).setCoach(null);
        Sportsman sportsman = sportsmanRepository.findSportsmanById(sportsmanId);
        sportsman.setClub(clubRepository.findClubById(nextClubId));

        sportsmanRepository.addSportsman(sportsman);
    }
}