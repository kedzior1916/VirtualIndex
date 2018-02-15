package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Promoter;
import com.projekt.wirtualny_indeks.index.models.Student;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Promoter*/
public interface PromoterService {
    /**
     *Metoda zwracająca liste wszystkich promotorów w tabeli
     * @return Zwraca listę promotorów
     */
    List<Promoter> findAll();

    /**
     *Metoda zwracająca promotora o wybranym id
     * @param id Id szukanego promotora
     * @return Zwraca znalezionego promotora o danym id
     */
    Promoter findById(int id);

    /**
     *Metoda zapisująca promotora do tabeli
     * @param promoter Obiekt przeznaczony do zapisu do tabeli promotorów
     */
    void save(Promoter promoter);

    /**
     *Metoda usuwająca promotora o wybranym id
     * @param id Id usuwanego promotora
     */
    void delete(int id);

    /**
     *Metoda zwracająca promotora danego studenta
     * @param id Id studenta
     * @return Zwraca obiekt promotora studenta o danym id
     */
    Promoter findByStudentId(long id);

    /**
     *Metoda zwracająca promotorów z danego kierunku
     * @param id Id szukanego kierunku
     * @return Zwraca listę promotorów z kierunku o danym id
     */
    List<Promoter> findAllByCourseId(int id);



}
