package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/** Repozytorium służące do zarządzania tabelą z Dokumentami w bazie danych */
public interface DocumentRepository extends JpaRepository<Document,Integer> {

    @Query("SELECT d FROM Document  d WHERE d.id=(SELECT max(do.id) FROM Document do)")
    Document getLastDocument();

    @Query("SELECT d FROM Document d WHERE d.user.id=?1")
    List<Document> getAllDocumentsByUserId(long id);

}
