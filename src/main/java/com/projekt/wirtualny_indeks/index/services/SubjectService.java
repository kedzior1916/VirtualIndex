package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Course;
import com.projekt.wirtualny_indeks.index.models.Subject;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Subjects*/
public interface SubjectService {
    /**
     *Metoda zwracająca liste wszystkich przedmiotów
     * @return Zwraca liste przedmiotów
     */
    List<Subject> getAllSubjects();

    List<Subject> getAllSubjectsByCourseId(int id);
    /**
     *Metoda zwracająca przedmiot o wybranym id
     * @param id Id szukanego przedmiotu
     * @return Zwraca znaleziony przedmiot o danym id
     */
    Subject getSubject(int id);

    /**
     *Metoda usuwająca przedmiot o wybranym id
     * @param id Id usuwanego przedmiotu
     */
    void deleteSubject(int id);

    /**
     *Metoda zapisująca przedmiot do tabeli
     * @param subject Obiekt przedmiotu przeznaczony do zapisu do tabeli przedmiotów
     */
    void saveSubject(Subject subject);


    /**
     *Metoda zwracająca liste przedmiotów danego pracownika
     * @param id Id pracownika
     * @return Zwraca liste przedmiotów które sa prowadzone przez danego pracownika
     */
    List<Subject> findAllByEmployersId(long id);







}
