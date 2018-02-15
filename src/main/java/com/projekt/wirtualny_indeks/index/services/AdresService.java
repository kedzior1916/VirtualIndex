package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Adres;

import java.util.List;

/**Serwis służący do obslugi operacji na tabeli Adress*/
public interface AdresService {


    /**
     *Metoda zwracająca liste wszystkich adresów w tabeli
     * @return Zwraca listę adresów
     */
    List<Adres> getAllAdreses();

    /**
     *Metoda zwracająca adres o wybranym id
     * @param id Id szukanego adresu
     * @return Zwraca znaleziony adres o danym id
     */
    Adres getAdres(int id);

    /**
     *Metoda usuwająca adres o wybranym id
     * @param id Id usuwanego adresu
     */
    void deleteAdres(int id);

    /**
     *Metoda zapisująca adres do tabeli
     * @param adres Obiekt przeznaczony do zapisu do tabeli adresów
     */
    void saveAdres(Adres adres);

}
