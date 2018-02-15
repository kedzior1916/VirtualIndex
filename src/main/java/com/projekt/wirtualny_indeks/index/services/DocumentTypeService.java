package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.DocumentType;

import java.util.List;

/**Serwis służący do obslugi operacji na tabeli Document Type*/
public interface DocumentTypeService {
    /**
     *Metoda zwracająca liste wszystkich typów dokumentów w tabeli
     * @return Zwraca listę typów dokumentów
     */
    List<DocumentType> getAllDocumentsTypes();

    /**
     *Metoda zwracająca typ dokumentu o wybranym id
     * @param id Id szukanego dokumentu
     * @return Zwraca znaleziony typ dokumentu o danym id
     */
    DocumentType getDocumentType(int id);

    /**
     *Metoda usuwająca typ dokumentu o wybranym id
     * @param id Id usuwanego typu dokumentu
     */
    void deleteDocumentType(int id);

    /**
     *Metoda zapisująca typ dokumentu do tabeli
     * @param documentType Obiekt przeznaczony do zapisu do tabeli typów dokumentów
     */
    void saveDocumentType(DocumentType documentType);
}
