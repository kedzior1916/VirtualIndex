package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Course;
import com.projekt.wirtualny_indeks.index.models.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;




/** Repozytorium służące do zarządzania tabelą Rekrutacji w bazie danych */
public interface RecruitmentRepository extends JpaRepository<Recruitment,Integer> {

    @Query("select r from Recruitment r where r.enabled = false")
    /** Metoda mająca na celu zwrócenie listy rektutacyjnej z niezatwierdzonymi studentami*
     * @return Zwraca listę rekrutacyjną*/
    List<Recruitment> getUnchecked();

    @Query("select r from Recruitment r where r.enabled = true")
    /** Metoda mająca na celu zwrócenie listy rektutacyjnej z zatwierdzonymi studentami*
     * @return Zwraca listę rekrutacyjną*/
    List<Recruitment> getCheecked();

    @Query("select r from Recruitment r where r.student.id = ?1 and r.enabled = true")
    /** Metoda mająca na celu zwrócenie listy rektutacyjnej dla podanego Id studenta *
     * @param id id Studenta
     * @return Zwraca listę rekrutacyjną*/
    List<Recruitment> getRecruitmetsByStudentId(Long id);

    /** Metoda mająca na celu zwrócenie listy rektutacyjnej dla podanego Id Kierunku i numeru semestru *
     * @param id id Kierunku
     * @param semestr Numer semestru
     * @return Zwraca listę rekrutacyjną*/
    List<Recruitment> findAllByCourseIdAndStudentSemestr(int id, int semestr);

    /** Metoda mająca na celu zwrócenie danej rekrutacji dla podanego Id studenta *
     * @param id id Studenta
     * @return Zwraca rekrutację*/
    Recruitment findByStudentId(long id);



}
