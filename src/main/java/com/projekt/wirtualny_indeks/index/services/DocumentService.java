package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Document;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Docouments*/
public interface DocumentService {
    /**
     *Metoda zwracająca liste wszystkich dokumentów w tabeli
     * @return Zwraca listę dokumentów
     */
    List<Document> getAllDocuments();

    /**
     *Metoda zwracająca dokument o wybranym id
     * @param id Id szukanego dokumentu
     * @return Zwraca znaleziony dokument o danym id
     */
    Document getDocument(int id);

    Document getLastDocument();

    List<Document> getAllDocumentsByUserId(long id);

    /**
     *Metoda usuwająca dokument o wybranym id
     * @param id Id usuwanego dokumentu
     */
    void deleteDocument(int id);

    /**
     *Metoda zapisująca adres do tabeli
     * @param document Obiekt przeznaczony do zapisu do tabeli dokumentów
     */
    void saveDocument(Document document);
}
