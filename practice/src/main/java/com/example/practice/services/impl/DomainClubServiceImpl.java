package com.example.practice.services.impl;

import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.CoachDto;
import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;
import com.example.practice.exeptions.ClubHasCoachException;
import com.example.practice.exeptions.CoachPointsException;
import com.example.practice.exeptions.NoCoachException;
import com.example.practice.repositories.ClubRepository;
import com.example.practice.repositories.CoachRepository;
import com.example.practice.services.ClubService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private CoachRepository coachRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void addClub(ClubDto clubDto) {
        Club club = modelMapper.map(clubDto, Club.class);
        clubRepository.save(club);
    }

    @Override
    public void addCoach(CoachDto coach, int clubId) {
        Coach coachToAdd = modelMapper.map(coach, Coach.class);
        clubRepository.addCoach(coachToAdd, clubId);
    }

    @Override
    public List<ClubDto> findAllByCoachIsNull() {
        return clubRepository.findAllByCoachIsNull()
                .stream()
                .map((c -> modelMapper.map(c, ClubDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public int getPointsById(int id) {
        return clubRepository.getPointsById(id);
    }

    @Override
    public void transferCoach(int prevClubId, int nextClubId, int coachId) {

        if (clubRepository.findClubByID(prevClubId).getCoach() == null) {
            throw new NoCoachException(coachId);
        }

        if (clubRepository.findClubByID(nextClubId).getCoach() != null) {
            throw new ClubHasCoachException(nextClubId);
        }

        if (clubRepository.getPointsById(nextClubId) > coachRepository.findCoachPointsById(coachId)) {
            throw new CoachPointsException(coachId);
        }

        clubRepository.findClubByID(prevClubId).setCoach(null);
        clubRepository.addCoach(coachRepository.findCoachById(coachId), nextClubId);
    }
}