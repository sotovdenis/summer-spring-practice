package com.example.practice.repositories.impl;

import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;
import com.example.practice.entities.Style;
import com.example.practice.repositories.SportsmanRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class SportsmanRepositoryDao implements SportsmanRepository {

    @Autowired
    private BaseSportsmanRepo baseSportsmanRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addSportsman(Sportsman sportsman) {
        entityManager.persist(sportsman);
    }

    @Override
    public Sportsman findSportsmanById(int id) {
        return entityManager.find(Sportsman.class, id);
    }


    @Override
    public List<Sportsman> findAllToMakeAQueue(String style, int metres) {
        return baseSportsmanRepo.findAllToMakeAQueue(Style.fromValue(style), metres);
    }
}

@Repository
interface BaseSportsmanRepo extends JpaRepository<Sportsman, Integer> {

    //Search for the sportsman with entry entryTime, birthday and gender to make a swimming queue
    @Query(value = "select s from Sportsman s join SportsmanDistance sd where sd.entryTimeInMilliseconds = :entry and s.birthDate = :birthDate and s.gender = :gender")
    List<Sportsman> findAllByEntryTimeAndBirthDate(@Param(value = "entry") long entry,
                                                   @Param(value = "birthDate") Date birthDate,
                                                   @Param(value = "gender") Gender gender);

    @Query(value = "select sd.resultTimeInMilliseconds from SportsmanDistance sd join Sportsman s where s.id = :id")
    long findSportsmanResultTimeById(@Param(value = "id") int id);

    @Query(value = "select s.reachDate from Sportsman s where s.id = :id")
    Date findSportsmanReachDateById(@Param(value = "id") int id);


//        select s.surname, s.name, s.patronymic, cl.town, sd.entry_time, d.style from sportsman s
//    join sportsman_distance sd on s.id = sd.sportsman_id
//    join distance d on sd.distance_id = d.id
//    left join club cl on s.club_id = cl.id
//    where d.style = 3 and d.meters = 50
    @Query(value = "select s.surname, s.name, s.patronymic, cl.town, sd.entryTimeInMilliseconds, d.style from Sportsman s " +
            "join SportsmanDistance sd join Distance d left join Club cl where d.style = :style and d.meters = :meters")
    List<Sportsman> findAllToMakeAQueue(@Param(value = "style") int style,
                                        @Param(value = "meters") int meters);

}