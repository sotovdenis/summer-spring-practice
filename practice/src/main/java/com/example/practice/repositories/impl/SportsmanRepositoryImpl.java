package com.example.practice.repositories.impl;

import com.example.practice.dtos.QueueAllDto;
import com.example.practice.entities.*;
import com.example.practice.repositories.BaseCRURepository;
import com.example.practice.repositories.SportsmanRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SportsmanRepositoryImpl extends BaseCRURepository<Sportsman> implements SportsmanRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public SportsmanRepositoryImpl(Class<Sportsman> entity) {
        super(entity);
    }

    @Override
    public List<QueueAllDto> makeAQueue(String style, int meters) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<QueueAllDto> criteriaQuery = criteriaBuilder.createQuery(QueueAllDto.class);
        Root<SportsmanDistance> sportsmanDistanceRoot = criteriaQuery.from(SportsmanDistance.class);
        Join<SportsmanDistance, Sportsman> sportsmanRoot = sportsmanDistanceRoot.join("sportsman");
        Join<SportsmanDistance, Distance> distanceJoin = sportsmanDistanceRoot.join("distance");
        Join<Sportsman, Club> clubJoin = sportsmanRoot.join("club", JoinType.LEFT);

        criteriaQuery.multiselect(
                sportsmanRoot.get("surname"),
                sportsmanRoot.get("name"),
                sportsmanRoot.get("patronymic"),
                clubJoin.get("town"),
                sportsmanDistanceRoot.get("entryTimeInMilliseconds"),
                distanceJoin.get("style")
        );

        Predicate stylePredicate = criteriaBuilder.equal(distanceJoin.get("style"), "CRAWL");
        Predicate metersPredicate = criteriaBuilder.equal(distanceJoin.get("meters"), 50);

        criteriaQuery.where(criteriaBuilder.and(stylePredicate, metersPredicate));

        return entityManager.createQuery(criteriaQuery).getResultList();

//        return entityManager.createQuery("select s.surname, s.name, s.patronymic, cl.town, sd.entryTimeInMilliseconds, d.style from Sportsman s " +
//                        "join SportsmanDistance sd on s.id = sd.sportsman.id " +
//                        "join Distance d on sd.distance.id = d.id " +
//                        "left join Club  cl on s.club.id = cl.id " +
//                        "where d.style = :style and d.meters = :meters", Queue.class)
//                .setParameter("style", style)
//                .setParameter("meters", meters).getResultStream().toList();

    }
}