package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



/** Repozytorium służące do zarządzania tabelą z Pracownikami w bazie danych */
public interface EmployerRepository extends JpaRepository<Employer,Long> {

    /** Metoda mająca na celu zwrócenie Pracownika z bazy danych
     * @param id id pracownika, którego mamy zwrócić z bazy
     * @return Zwraca pracownika*/
    Employer findEmployerByUserId(long id);

    @Query("select e from Employer e where e.user.username = ?1")
    /** Metoda mająca na celu zwrócenie pracownika po podanej nazwie użytkownika z bazy danych
     * @param username Nazwa użytkownika
     * @return Zwraca pracownika*/
    Employer getEmployerByUsername(String username);
}
