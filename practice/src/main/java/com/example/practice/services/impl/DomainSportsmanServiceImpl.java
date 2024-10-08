package com.example.practice.services.impl;

import com.example.practice.dtos.*;
import com.example.practice.dtos.sportsman.KickSportsmanDto;
import com.example.practice.dtos.sportsman.NewCategoryDto;
import com.example.practice.dtos.sportsman.SportsmanDto;
import com.example.practice.entities.*;
import com.example.practice.exeptions.CategoryException;
import com.example.practice.exeptions.NoCoachException;
import com.example.practice.exeptions.NoSportsmanException;
import com.example.practice.repositories.ClubRepository;
import com.example.practice.repositories.CompetitionRepository;
import com.example.practice.repositories.SportsmanDistanceRepository;
import com.example.practice.repositories.SportsmanRepository;
import com.example.practice.repositories.impl.ClubRepositoryImpl;
import com.example.practice.repositories.impl.CompetitionRepositoryImpl;
import com.example.practice.repositories.impl.SportsmanDistanceRepositoryImpl;
import com.example.practice.repositories.impl.SportsmanRepositoryImpl;
import com.example.practice.services.SportsmanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainSportsmanServiceImpl implements SportsmanService {

    @Autowired
    private SportsmanRepository sportsmanRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    private static boolean isSetCategory(Category category, int competitionPoint) {
        boolean setCategory = false;

        switch (category) {
            case THIRDCHILD -> {
                switch (competitionPoint) {
                    case 0, 1, 2, 5, 4, 3 -> setCategory = true;
                }
            }
            case SECONDCHILD -> {
                switch (competitionPoint) {
                    case 1, 2, 5, 4, 3 -> setCategory = true;
                }
            }
            case FIRSTCHILD, THIRDADULT -> {
                switch (competitionPoint) {
                    case 2, 5, 4, 3 -> setCategory = true;
                }
            }
            case FIRSTADULT, SECONDADULT, CMS -> {
                switch (competitionPoint) {
                    case 5, 4, 3 -> setCategory = true;
                }
            }
            case MS, MSIC -> {
                switch (competitionPoint) {
                    case 5, 4 -> setCategory = true;
                }
            }
            case MMS -> {
                if (competitionPoint == 5) {
                    setCategory = true;
                }
            }
        }
        return setCategory;
    }

    @Override
    public void updateSportsmanClubSetNullById(KickSportsmanDto kickSportsmanDto) {
        Sportsman sportsman = sportsmanRepository.findById(Sportsman.class, kickSportsmanDto.getId());
        sportsman.setClub(null);

        sportsmanRepository.update(sportsman);
    }

    @Override
    public void addSportsman(SportsmanDto sportsmanDto) {
        Sportsman sportsmanToAdd = modelMapper.map(sportsmanDto, Sportsman.class);

        Club club = clubRepository.findById(Club.class, sportsmanDto.getClubId());
        sportsmanToAdd.setClub(club);

        sportsmanRepository.save(sportsmanToAdd);

    }

    @Override
    public void transferSportsman(TransferDto transferDto) {

        int prevClubId = transferDto.getPrevClubId();
        int nextClubId = transferDto.getNextClubId();
        int sportsmanId = transferDto.getId();

        if (sportsmanRepository.findById(Sportsman.class, sportsmanId) == null) {
            throw new NoSportsmanException(sportsmanId);
        }

        clubRepository.findById(Club.class, prevClubId).setCoach(null);
        Sportsman sportsman = sportsmanRepository.findById(Sportsman.class, sportsmanId);
        sportsman.setClub(clubRepository.findById(Club.class, nextClubId));

        sportsmanRepository.update(sportsman);
    }

    @Override
    public void setNewCategory(NewCategoryDto newCategoryDto) {

        CompetitionStatus competitionStatus = competitionRepository.getCompetitionStatusById(newCategoryDto.getCompetitionId());
        int sportsmanId = newCategoryDto.getSportsmanId();
        Category category = Category.valueOf(newCategoryDto.getNewCategory());

        int competitionPoint = 0;

        switch (competitionStatus) {
            case REGIONAL -> competitionPoint = 1;
            case LOCAL -> competitionPoint = 2;
            case DISTRICT -> competitionPoint = 3;
            case COUNTRY -> competitionPoint = 4;
            case WORLD -> competitionPoint = 5;
        }

        boolean setCategory = isSetCategory(category, competitionPoint);

        Sportsman sportsman = sportsmanRepository.findById(Sportsman.class, sportsmanId);

        if (setCategory) {
            sportsman.setCategory(category);
        } else
            throw new CategoryException(newCategoryDto.getCompetitionId(), sportsmanId);

        sportsmanRepository.update(sportsman);

    }

    @Override
    public List<QueueAllDto> makeAQueue(QueueDto queueDto) {
//        Style style = null;
//        switch (queueDto.getStyle()){
//            case 0 -> style = Style.BUTTERFLY;
//            case 1 -> style = Style.BACKSTROKE;
//            case 2 -> style = Style.CRAWL;
//            case 3 -> style = Style.BREASTSTROKE;
//            case 4 -> style = Style.MEDLEY;
//        }
//
//        assert style != null;

        //        return entityManager.createQuery("select s.surname, s.name, s.patronymic, cl.town, sd.entryTimeInMilliseconds, d.style from Sportsman s " +
//                        "join SportsmanDistance sd on s.id = sd.sportsman.id " +
//                        "join Distance d on sd.distance.id = d.id " +
//                        "left join Club  cl on s.club.id = cl.id " +
//                        "where d.style = :style and d.meters = :meters", Queue.class)
//                .setParameter("style", style)
//                .setParameter("meters", meters).getResultStream().toList();



        return sportsmanRepository.makeAQueue(queueDto.getStyle(), queueDto.getMeters())
                .stream()
                .map(s -> modelMapper.map(s, QueueAllDto.class))
                .toList();
    }
}