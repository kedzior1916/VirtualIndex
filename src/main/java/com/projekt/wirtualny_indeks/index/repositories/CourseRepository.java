package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/** Repozytorium służące do zarządzania tabelą z Kierunkami w bazie danych */
public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Query("select r from Course r where r.typ like ?1 and r.rodzaj like ?2")
    List<Course> getFilteredCourses(String typ, String rodzaj);
}
