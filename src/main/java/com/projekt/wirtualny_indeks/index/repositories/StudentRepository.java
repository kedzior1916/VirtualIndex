package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;




/** Repozytorium służące do zarządzania tabelą ze Studentami w bazie danych */
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s WHERE "+
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "upper(s.imie) LIKE upper(:phrase) OR " +
            "upper(s.nazwisko) LIKE upper(:phrase) OR " +
            "concat(upper(s.imie),' ',upper(s.nazwisko)) LIKE upper(:phrase)"+
            ") ")
    /** Metoda mająca na celu zwrócenie listy studentów z wykorzystaniem podanego filtru *
     * @param p Filtr
     * @return Zwraca listę studentów*/
    List<Student> findAllStudentsUsingFilter(@Param("phrase")String p);

    @Query("select s from Student s where s.user.username = ?1")
    /** Metoda mająca na celu zwrócenie studenta po podanej nazwie użytkownika *
     * @param username Nazwa użytkownika
     * @return Zwraca studenta*/
    Student getStudentByUsername(String username);

    @Query("SELECT s FROM Student s WHERE s.user.id = ?1")
    Student getStudentByUserId(long id);

    Student findByEmail(String email);
}
