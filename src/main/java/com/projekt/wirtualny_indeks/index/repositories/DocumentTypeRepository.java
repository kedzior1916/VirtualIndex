package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;




/** Repozytorium służące do zarządzania tabelą z Typami dokumentów w bazie danych */
public interface DocumentTypeRepository extends JpaRepository<DocumentType,Integer> {
}
