package com.example.practice.services.impl;

import com.example.practice.dtos.sportsman.AddSportsmanDistanceDto;
import com.example.practice.dtos.sportsman.AddSportsmanResultTimeDto;
import com.example.practice.entities.Distance;
import com.example.practice.entities.Sportsman;
import com.example.practice.entities.SportsmanDistance;
import com.example.practice.repositories.DistanceRepository;
import com.example.practice.repositories.SportsmanDistanceRepository;
import com.example.practice.repositories.SportsmanRepository;
import com.example.practice.services.SportsmanDistanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsmanDistanceServiceImpl implements SportsmanDistanceService {

    @Autowired
    private SportsmanDistanceRepository sportsmanDistanceRepository;
    @Autowired
    private SportsmanRepository sportsmanRepository;
    @Autowired
    private DistanceRepository distanceRepository;

    private final ModelMapper modelMapper = new ModelMapper();
//
//    @Override
//    public List<SportsmanDistance> findAllByResultTimeInMilliseconds(long resultTime) {
//        return sportsmanDistanceRepository.findAllByResultTimeInMilliseconds(resultTime);
//    }

    @Override
    public void setResultTime(AddSportsmanResultTimeDto time) {
        int sdId = time.getSdId();
        long resultTimeInMilliseconds = time.getResult();

        SportsmanDistance sd = sportsmanDistanceRepository.findSportsmanDistanceById(sdId);
        sd.setResultTimeInMilliseconds(resultTimeInMilliseconds);

        sportsmanDistanceRepository.addSportsmenDistance(sd);
    }

    @Override
    public void addSportsmanDistance(AddSportsmanDistanceDto addSportsmanDistanceDto) {
        SportsmanDistance sd = modelMapper.map(addSportsmanDistanceDto, SportsmanDistance.class);
        Sportsman sportsman = sportsmanRepository.findSportsmanById(addSportsmanDistanceDto.getSportsmanId());
        Distance distance = distanceRepository.findDistanceById(addSportsmanDistanceDto.getDistanceId());

        sd.setSportsman(sportsman);
        sd.setDistance(distance);

        sportsmanDistanceRepository.addSportsmenDistance(sd);
    }
}