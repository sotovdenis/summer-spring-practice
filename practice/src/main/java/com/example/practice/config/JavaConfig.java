package com.example.practice.config;


import com.example.practice.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {


    @Bean
    public Class<Club> clubClass() {
        return Club.class;
    }

    @Bean
    public Class<Coach> coachClass() {
        return Coach.class;
    }

    @Bean
    public Class<SportsmanDistance> sportsmanDistanceClass() {
        return SportsmanDistance.class;
    }

    @Bean
    public Class<Sportsman> sportsmanClass() {
        return Sportsman.class;
    }

    @Bean
    public Class<Competition> competitionClass() {
        return Competition.class;
    }

    @Bean
    public Class<Distance> distanceClass() {
        return Distance.class;
    }
}
