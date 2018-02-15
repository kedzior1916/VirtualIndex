package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.RegistrationEmployer;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Adress*/
public interface RegistrationEmployerService {
    /**
     *Metoda zwracająca liste wszystkich pracowników w tabeli
     * @return Zwraca listę pracowników
     */
    List<RegistrationEmployer> findAll();

    /**
     *Metoda zwracająca rejestracje pracownika
     * @param id Id szukanej rejestracji
     * @return Zwraca rejestracje
     */
    RegistrationEmployer getRegistrationEmployer(int id);

    /**
     *Metoda zapisująca rejestracje pracownika do tabeli
     * @param registrationEmployer Rejestracja pracownika przeznaczona do zapisu do tabeli
     */
    void saveRegistrationEmployer(RegistrationEmployer registrationEmployer);

    /**
     *Metoda usuwająca rejestracje
     */
    void deleteRegistrationEmployer();

    /**
     *Metoda zwracająca rejestrację według tokenu
     * @param string Specjalny token do autoryzacji
     * @return Zwraca rehestrache odpowiadającą tokienowi
     */
    RegistrationEmployer findByToken(String string);

}
