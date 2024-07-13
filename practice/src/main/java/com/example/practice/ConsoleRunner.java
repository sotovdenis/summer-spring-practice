package com.example.practice;


import com.example.practice.entities.Club;
import com.example.practice.entities.Coach;
import com.example.practice.services.ClubService;
import com.example.practice.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ClubService clubService;
    @Autowired
    private CoachService coachService;

    @Override
    public void run(String... strings) throws Exception {
        Coach coach = new Coach("Mayorov","Evgeny","Egorovich", 1300);
        coachService.addCoach(coach);

        Club club = new Club("Sergiev-Posad", coach, 1200);
        clubService.addClub(club);

    }
}