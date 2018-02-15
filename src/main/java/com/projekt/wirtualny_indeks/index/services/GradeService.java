package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.controllers.commands.GradeFilter;
import com.projekt.wirtualny_indeks.index.models.Grade;
import com.projekt.wirtualny_indeks.index.models.Student;

import java.util.List;

/**Serwis służący do obslugi operacji na tabeli Grades*/
public interface GradeService {

    /**
     *Metoda zwracająca liste ocen według filtru ocen
     * @param phrase Filtr ocen
     * @return Zwraca listę ocen według filtru
     */
    List<Grade> getAllGrades(GradeFilter phrase);

    List<Grade> getAllGrades();
    /**
     *Metoda zwracająca ocenę o wybranym id
     * @param id Id szukanej oceny
     * @return Zwraca znalezioną ocene o danym id
     */
    Grade getGrade(int id);

    /**
     *Metoda zwracająca listę ocen danego studenta
     * @param id Id studenta
     * @return Zwraca listę ocen studenta o danym id
     */
    List<Grade> GetGradesByStudentId(long id);

    /**
     *Metoda usuwająca ocenę o wybranym id
     * @param id Id usuwanej oceny
     */
    void deleteGrade(int id);

    /**
     *Metoda zapisująca ocenę do tabeli
     * @param grade Obiekt przeznaczony do zapisu do tabeli ocen
     */
    void saveGrade(Grade grade);

    /**
     * Metoda zwracająca listę ocen z danego terminu
     * @param termin Liczba określająca numer terminu
     * @return Zwraca listę ocen z danego terminu
     */
    List<Grade> findAllByTermin(int termin);


}
