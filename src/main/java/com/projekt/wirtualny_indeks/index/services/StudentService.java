package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.controllers.commands.StudentFilter;
import com.projekt.wirtualny_indeks.index.models.Student;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Students*/
public interface StudentService {
    /**
     *Metoda zwracająca listę studentów według określonego filtra
     * @param filter Filter określający co metoda ma zwrócić
     * @return Zwraca liste studentów odpowiadających filtrowi
     */
    List<Student> getAllStudents(StudentFilter filter);

    /**
     *Metoda zwracająca studenta o wybranym id
     * @param id Id szukanego studenta
     * @return Zwraca znalezionego studenta o danym id
     */
    Student getStudent(long id);

    /**
     *Metoda sprawdzająca unikalność loginu
     * @param email Email wprowadzony w formularzu wymagający sprawdzniea
     * @return Zwraca true jeśli email jest unikalny
     */
    boolean isUniqueEmail(String email);


    Student getStudentByUserId(long id);

    /**
     *Metoda usuwająca studenta o wybranym id
     * @param id Id usuwanego studenta
     */
    void deleteStudent(long id);

    /**
     *Metoda zapisująca studenta do tabeli
     * @param student Obiekt przeznaczony do zapisu do tabeli studentów
     */
    void saveStudent(Student student);

    /**
     *Metoda aktualizująca dane studenta
     * @param student Obiekt studenta z wprowadzonymi zmianami
     */
    void updateStudent(Student student);

    /**
     *Metoda zwracająca studenta o danej nazwie użytkownika
     * @param name Nazwa użytkownika szukanego studenta
     * @return
     */
    Student getStudentByUsername(String name);
}
