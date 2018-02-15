package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




/** Repozytorium służące do zarządzania tabelą z Użytkownikami bazie danych */
public interface UserRepository extends JpaRepository<User,Long> {

    /** Metoda mająca na celu zwrócenie użytkownika po jego nazwie *
     * @param username Nazwa użytkownika
     * @return Zwraca użytkownika*/
    User findByUsername(String username);
}
