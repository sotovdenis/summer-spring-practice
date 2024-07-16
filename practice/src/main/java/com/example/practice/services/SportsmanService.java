package com.example.practice.services;

import com.example.practice.dtos.*;
import com.example.practice.entities.Category;
import com.example.practice.entities.Gender;
import com.example.practice.entities.Sportsman;
import com.example.practice.entities.Style;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;

public interface SportsmanService {

    void updateSportsmanClubSetNullById(KickSportsmanDto kickSportsmanDto);

    void addSportsman(SportsmanDto sportsman);

    List<SportsmanDto> findAllToMakeAQueue(String style, int meters);

    void transferSportsman(TransferDto transferDto);

    void setNewCategory(NewCategoryDto newCategoryDto);

}