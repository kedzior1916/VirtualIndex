package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Adres;
import org.springframework.data.jpa.repository.JpaRepository;


/** Repozytorium służące do zarządzania tabelą z Adresami w bazie danych */
public interface AdresRepository extends JpaRepository<Adres,Integer> {
}
