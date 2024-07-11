package com.example.practice.repositories;

import com.example.practice.entities.Coach;
import com.example.practice.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface NameRepository<T extends Human> extends JpaRepository<T, Integer> {
    List<Coach> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);
}
