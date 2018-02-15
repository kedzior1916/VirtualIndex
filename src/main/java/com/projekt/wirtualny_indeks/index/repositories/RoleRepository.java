package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;



/** Repozytorium służące do zarządzania tabelą z Rolami w bazie danych */
public interface RoleRepository extends JpaRepository<Role,Integer> {

    /** Metoda mająca na celu zwrócenie roli po podanym typie roli*
     * @param type Typ roli
     * @return Zwraca rolę*/
    Role findRoleByType(Role.Types type);
}
