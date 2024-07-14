package com.example.practice.repositories.impl;

import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;
import com.example.practice.repositories.SportsmanRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class SportsmanRepositoryDao implements SportsmanRepository {

    @Autowired
    private BaseSportsmanRepo baseSportsmanRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addSportsman(Sportsman sportsman) {
        entityManager.persist(sportsman);
    }

    @Transactional
    public void deleteSportsman(int id) {
        entityManager.remove(entityManager.find(Sportsman.class, id));
    }

    @Override
    public Sportsman findSportsmanById(int id) {
        return entityManager.find(Sportsman.class, id);
    }

    @Override
    public List<Sportsman> findAllByCategory(Category category) {
        return baseSportsmanRepo.findAllByCategory(category);
    }

    @Override
    public List<Sportsman> findAllByEntryTimeAndBirthDate(long entry, Date birthDate, Gender gender) {
        return baseSportsmanRepo.findAllByEntryTimeAndBirthDate(entry, birthDate, gender);
    }

    @Override
    public void updateCategoryById(int id, Category category) {
        baseSportsmanRepo.updateSportsmanCategoryById(category, id);
    }

    @Override
    public void updateSportsmanClubSetNull(int id) {
        baseSportsmanRepo.updateSportsmanClubSetNull(id);
    }

    @Override
    public long findSportsmanResultTimeById(int id) {
        return baseSportsmanRepo.findSportsmanResultTimeById(id);
    }

    @Override
    public Date findSportsmanReachDateById(int id) {
        return baseSportsmanRepo.findSportsmanReachDateById(id);
    }
}

@Repository
interface BaseSportsmanRepo extends JpaRepository<Sportsman, Integer> {

    List<Sportsman> findAllByCategory(Category category);

    //Search for the sportsman with entry entryTime, birthday and gender to make a swimming queue
    @Query(value = "select s from Sportsman s join SportsmanDistance sd where sd.entryTimeInMilliseconds = :entry and s.birthDate = :birthDate and s.gender = :gender")
    List<Sportsman> findAllByEntryTimeAndBirthDate(@Param(value = "entry") long entry,
                                                   @Param(value = "birthDate") Date birthDate,
                                                   @Param(value = "gender") Gender gender);

    @Query(value = "update Sportsman s set s.category = :category where s.id = :id ")
    void updateSportsmanCategoryById(@Param(value = "category") Category category,
                                     @Param(value = "id") int id);

    @Query(value = "update Sportsman s set s.club = null where s.id = :id")
    void updateSportsmanClubSetNull(@Param(value = "id") int id);

    @Query(value = "select sd.resultTimeInMilliseconds from SportsmanDistance sd join Sportsman s where s.id = :id")
    long findSportsmanResultTimeById(@Param(value = "id") int id);

    @Query(value = "select s.reachDate from Sportsman s where s.id = :id")
    Date findSportsmanReachDateById(@Param(value = "id") int id);

}