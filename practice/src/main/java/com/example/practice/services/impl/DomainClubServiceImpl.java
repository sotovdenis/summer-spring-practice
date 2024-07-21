package com.example.practice.services.impl;

import com.example.practice.dtos.club.ClubDto;
import com.example.practice.dtos.coach.AddCoachToClubDto;
import com.example.practice.dtos.TransferDto;
import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;
import com.example.practice.exeptions.ClubHasCoachException;
import com.example.practice.exeptions.CoachPointsException;
import com.example.practice.exeptions.NoCoachException;
import com.example.practice.repositories.CoachRepository;
import com.example.practice.repositories.impl.ClubRepositoryImpl;
import com.example.practice.repositories.impl.CoachRepositoryImpl;
import com.example.practice.services.ClubService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepositoryImpl clubRepository;
    @Autowired
    private CoachRepositoryImpl coachRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void addClub(ClubDto clubDto) {
        Coach coach = coachRepository.findById(Coach.class, clubDto.getCoachId());

        Club club = modelMapper.map(clubDto, Club.class);

        club.setCoach(coach);
        clubRepository.save(club);
    }

    @Override
    public void addCoachToClub(AddCoachToClubDto addCoachToClubDto) {
        int clubId = addCoachToClubDto.getClubId();
        int coachId = addCoachToClubDto.getCoachId();

        Club club = clubRepository.findById(Club.class, clubId);
        club.setCoach(coachRepository.findById(Coach.class, coachId));

        clubRepository.update(club);
    }

    @Override
    public void transferCoach(TransferDto transferDto) {

        int prevClubId = transferDto.getPrevClubId();
        int nextClubId = transferDto.getNextClubId();
        int coachId = transferDto.getId();


        if (clubRepository.findById(Club.class, prevClubId).getCoach() == null) {
            throw new NoCoachException(coachId);
        }

        if (clubRepository.findById(Club.class, nextClubId).getCoach() != null) {
            throw new ClubHasCoachException(nextClubId);
        }

        if (clubRepository.findById(Club.class, nextClubId).getPoints() > coachRepository.findCoachPointsById(coachId)) {
            throw new CoachPointsException(coachId);
        }

        clubRepository.findById(Club.class, prevClubId).setCoach(null);
        Club club = clubRepository.findById(Club.class, nextClubId);
        club.setCoach(coachRepository.findById(Coach.class, coachId));

        clubRepository.update(club);
    }
}