package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Grade;
import com.projekt.wirtualny_indeks.index.models.Student;
import com.projekt.wirtualny_indeks.index.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;




/** Repozytorium służące do zarządzania tabelą z Ocenami w bazie danych */
public interface GradeRepository extends JpaRepository<Grade,Integer> {

    @Query("SELECT s FROM Grade s WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "upper(s.student.imie) LIKE upper(:phrase) OR " +
            "upper(s.student.nazwisko) LIKE upper(:phrase))")
    /** Metoda mająca na celu zwrócenie listy ocen używając filtra
     * @param p filtr wyszukiwający
     * @return Zwraca listę ocen*/
    List<Grade> findAllGradesUsingFilter(@Param("phrase") String p);

    @Query("SELECT g FROM Grade g WHERE"+
            "(g.student.id = (:id))")
    /** Metoda mająca na celu zwrócenie listy ocen dla podanego Id studenta
     * @param id Id studenta
     * @return Zwraca listę ocen*/
    List<Grade> findAllGradesByStudentId(@Param("id") long id);

    /** Metoda mająca na celu zwrócenie listy studentów po wybranym Id kursu i numerze semestru
     * @param courseId Id kursu
     * @param semestr Numer semestru
     * @return Zwraca listę studentów*/
    List<Student> findAllByCourseIdAndStudentSemestr(int courseId, int semestr);

    /** Metoda mająca na celu zwrócenie listy ocen dla podanego numeru terminu
     * @param termin Numer terminu
     * @return Zwraca listę ocen*/
    List<Grade> findAllByTermin(int termin);


}
