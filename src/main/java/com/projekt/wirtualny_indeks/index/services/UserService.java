package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
/**Serwis służący do obslugi operacji na tabeli Users*/
public interface UserService extends UserDetailsService {
    /**
     *Metoda zapisująca użytkownika do tabeli
     * @param user Obiekt użytkownika przeznaczony do zapisu do tabeli
     */
    void save(User user);

    /**
     *Metoda sprawdzająca unikalność loginu
     * @param login Login wprowadzony w formularzu wymagający sprawdzniea
     * @return Zwraca true jeśli login jest unikalny
     */
    boolean isUniqueLogin(String login);

    /**
     *Metoda zwracająca użytkownika o danym id użytkownika
     * @param name Nazwa szukanego użytkownika
     * @return Zwraca znalezionego użytkownika o danej nazwie użytkownika
     */
    User getUserByName(String name);

    /**
     *Metoda zapisująca użytkownika do tabeli
     * @param user Obiekt przeznaczony do zapisu do tabeli użytkowników
     */
    void update(User user);

    /**
     *Metoda aktualizująca obiekt użytkownika jeśeli podane stare hasło się zgadza
     * @param user Obiekt użytkownika którego dotyczy zmiana hasła
     * @param pass Stare gasło podane w formularzu
     * @return Jeżeli podane przez użytkownika stare hasło w formularzu zmiany hasła się zgadza, metoda zwraca true
     */
    boolean update(User user, String pass);
}
