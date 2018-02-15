package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Course;
import com.projekt.wirtualny_indeks.index.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;




/** Repozytorium służące do zarządzania tabelą z Przedmiotami w bazie danych */
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    /** Metoda mająca na celu zwrócenie listy przedmiotów dla podanego id Pracownika *
     * @param id Pracownika
     * @return Zwraca listę przedmiotów*/
    List<Subject> findSubjectsByEmployers(long id);

    /** Metoda mająca na celu zwrócenie listy przedmiotów dla podanego id Pracownika *
     * @param id Pracownika
     * @return Zwraca listę przedmiotów*/
    List<Subject> findAllByEmployersId(long id);

    @Query("SELECT s FROM Subject s WHERE s.course.id = :id")
    List<Subject> findAllByCourseId(@Param("id") int id);




}
