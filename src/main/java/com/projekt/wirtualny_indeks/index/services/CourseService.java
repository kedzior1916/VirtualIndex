package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Course;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Courses*/
public interface CourseService {

    /**
     *Metoda zwracająca listę wszystkich kierunków w tabeli
     * @return Zwraca listę kierunków
     */
    List<Course> getAllCourses();


    List<Course> getFilteredCourses(String typ, String rodzaj);

    /**
     *Metoda zwracająca kierunek o wybranym id
     * @param id Id szukanego kierunku
     * @return Zwraca znaleziony adres o danym id
     */
    Course getCourse(int id);

    /**
     *Metoda usuwająca kierunek o wybranym id
     * @param id Id usuwanego kierunku
     */
    void deleteCourse(int id);

    /**
     *Metoda zapisująca kierunek do tabeli
     * @param course Obiekt przeznaczony do zapisu w tabeli kierunków
     */
    void saveCourse(Course course);

}
