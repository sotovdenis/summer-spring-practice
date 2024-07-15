package com.example.practice.services.impl;

import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.AddCoachToClubDto;
import com.example.practice.dtos.TransferDto;
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
        Coach coach = coachRepository.findCoachById(clubDto.getCoachId());

        Club club = modelMapper.map(clubDto, Club.class);

        club.setCoach(coach);
        clubRepository.save(club);
    }

    @Override
    public void addCoachToClub(AddCoachToClubDto addCoachToClubDto) {
        int clubId = addCoachToClubDto.getClubId();
        int coachId = addCoachToClubDto.getCoachId();

        Club club =  clubRepository.findClubById(clubId);
        club.setCoach(coachRepository.findCoachById(coachId));

        clubRepository.save(club);
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
    public void transferCoach(TransferDto transferDto) {

        int prevClubId = transferDto.getPrevClubId();
        int nextClubId = transferDto.getNextClubId();
        int coachId = transferDto.getId();


        if (clubRepository.findClubById(prevClubId).getCoach() != null) {
            throw new NoCoachException(coachId);
        }

        if (clubRepository.findClubById(nextClubId).getCoach() != null) {
            throw new ClubHasCoachException(nextClubId);
        }

        if (clubRepository.getPointsById(nextClubId) > coachRepository.findCoachPointsById(coachId)) {
            throw new CoachPointsException(coachId);
        }

        clubRepository.findClubById(prevClubId).setCoach(null);
        Club club =  clubRepository.findClubById(nextClubId);
        club.setCoach(coachRepository.findCoachById(coachId));

        clubRepository.save(club);
    }
}