package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Employer;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Eployers*/
public interface EmployerService {
    /**
     *Metoda zwracająca liste wszystkich pracowników w tabeli
     * @return Zwraca listę pracowników
     */
    List<Employer> getAllEmployers();

    /**
     *Metoda zwracająca pracownika o wybranym id
     * @param id Id szukanego pracownika
     * @return Zwraca znalezionego pracownika o danym id
     */
    Employer getEmployers(long id);

    /**
     *Metoda usuwająca pracownika o wybranym id
     * @param id Id usuwanego pracownika
     */
    void deleteEmployer(long id);

    /**
     *Metoda zapisująca pracownika do tabeli
     * @param employer Obiekt przeznaczony do zapisu do tabeli pracowników
     */
    void saveEmployer(Employer employer);

    /**
     *Metoda zwracająca pracowynika o wybranym id użytkownika
     * @param id Id szukanego pracownika
     * @return Zwraca znalezionego pracownika o danym id użytkownika
     */
    Employer findEmployerByUserId(long id);

    /**
     *Metoda zwracająca pracownika o danej nazwie użytkownika
     * @param name Usrname szukanego użytkownika
     * @return Zwraca znalezonego pracownika o danej nazwie użytkownika
     */
    Employer getEmployerByUsername(String name);
}
