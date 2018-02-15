package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.RegistrationEmployer;
import org.springframework.data.jpa.repository.JpaRepository;



/** Repozytorium służące do zarządzania tabelą przechowująceją tokeny potrzebne do rejestracji Pracownika */
public interface RegistrationEmployerRepository extends JpaRepository<RegistrationEmployer,Integer> {

    /** Metoda mająca na celu zwrócenie validację tokena podanego w linku przeglądarki *
     * @param string token validujący
     * @return Zwraca obiekt validujący rejestrację*/
    RegistrationEmployer findByToken(String string);
}
