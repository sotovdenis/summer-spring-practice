package com.example.practice;


import com.example.practice.entities.*;
import com.example.practice.repositories.CoachRepository;
import com.example.practice.repositories.SportsmanRepository;
import com.example.practice.services.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
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

    @Override
    public void run(String... strings) throws Exception {
        Coach coach = new Coach("Mayorov","Evgeny","Egorovich", 1300);
        coachService.addCoach(coach);

        Club club = new Club("Sergiev-Posad", coach, 1200);
        clubService.addClub(club);

        Club club2 = new Club("Moscow", null, 2000);
        clubService.addClub(club2);
        clubService.findAllByCoachIsNull();

        Date date = new Date();
        date.setTime(12333423);

        Gender gender = Gender.MALE;
        Category category = Category.CMS;

        Sportsman sportsman = new Sportsman("Sotov", "Denis", "Ruslalovich", date, gender, category, date, club);
        sportsmanRepository.addSportsman(sportsman);
        sportsmanRepository.updateCategoryById(1, Category.MS);
        sportsmanRepository.updateSportsmanClubSetNull(1);
        sportsmanRepository.findSportsmanReachDateById(1);
        System.out.println();
        System.out.println(coachRepository.findCoachPointsById(1));
        System.out.println();
        Competition competition = new Competition(new Date(123123123), new Date(234235235), "Ramenskoe", "imeni MiiTa", CompetitionStatus.DISTRICT);
        competitionService.addCompetition(competition);
        distanceService.addDistance(new Distance(Style.CRAWL, 50, competition ));
        System.out.println(competitionService.findAllByCompetitionStatus(CompetitionStatus.DISTRICT).toString());
        System.out.println(distanceService.findAllByStyleAndMeters(Style.CRAWL, 50).toString());


    }
}