package com.example.practice;


import com.example.practice.dtos.ClubDto;
import com.example.practice.dtos.CoachDto;
import com.example.practice.dtos.SportsmanDto;
import com.example.practice.entities.*;
import com.example.practice.repositories.CoachRepository;
import com.example.practice.repositories.SportsmanRepository;
import com.example.practice.services.*;
import lombok.Getter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ClubService clubService;
    @Autowired
    private CoachService coachService;
    @Autowired
    private SportsmanService sportsmanRepository;
    @Autowired
    private CoachService coachRepository;
    @Autowired
    private DistanceService distanceService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private SportsmanDistanceService sportsmanDistanceService;

    @Override
    public void run(String... strings) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        Coach coach = new Coach("Mayorov", "Evgeny", "Egorovich", 1300);

        Club club = new Club("Sergiev-Posad", coach, 1200);

        CoachDto coachDto = modelMapper.map(coach, CoachDto.class);
        ClubDto clubDto = modelMapper.map(club, ClubDto.class);

        clubService.addClub(clubDto);
        coachService.addCoach(coachDto);

        Club club2 = new Club("Moscow", null, 2000);


        ClubDto clubDto2 = modelMapper.map(club2, ClubDto.class);
        clubService.addClub(clubDto2);
        clubService.findAllByCoachIsNull();

        Date date = new Date();
        date.setTime(12333423);

        Gender gender = Gender.MALE;
        Category category = Category.CMS;


//        Sportsman sportsman = new Sportsman("Sotov", "Denis", "Ruslalovich", date.getTime(), gender, category, date.getTime(), club);
//        SportsmanDto sportsmanDto = new SportsmanDto
//                ("Sotov", "Denis", "Ruslalovich", "12312313", "MALE", "CMS", "1231233", 1);
//        sportsmanRepository.addSportsman(sportsmanDto);
//        System.out.println();
//        System.out.println(coachRepository.findCoachPointsById(1));
//        System.out.println();
        Competition competition = new Competition(12123323, 123123, "Ramenskoe", "imeni MiiTa", CompetitionStatus.WORLD);
        competitionService.addCompetition(competition);
//        Distance distance = new Distance(Style.CRAWL, 50, competition );
//        distanceService.addDistance(distance);
//        System.out.println(competitionService.findAllByCompetitionStatus(CompetitionStatus.DISTRICT).toString());
//        System.out.println(distanceService.findAllByStyleAndMeters(Style.CRAWL, 50).toString());
//        System.out.println();
//        SportsmanDistance sportsmanDistance = new SportsmanDistance(sportsman, distance, 45421341, 0);
//        sportsmanDistanceService.addSportsmanEntryTime(sportsmanDistance);
//        sportsmanDistanceService.setResultTime(1, 321412342);


    }
}