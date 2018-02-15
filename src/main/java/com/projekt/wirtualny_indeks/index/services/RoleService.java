package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Role;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Roles*/
public interface RoleService {
    /**
     *Metoda zwracająca liste wszystkich ról w tabeli
     * @return Zwraca listę ról
     */
    List<Role> getAllRoles();

    /**
     *Metoda zwracająca rolę danego typu
     * @param type Typ roli
     * @return Zwraca obiekt roli
     */
    Role findRoleByTypeRole(Role.Types type);

    /**
     * Metoda zwracająca rolę o wybranym id
     * @param id Id szukanej roli
     * @return Zwraca znalezioną rolę o danym id
     */
    Role getRole(int id);

    /**
     *Metoda usuwająca rolę o wybranym id
     * @param id Id usuwanej roli
     */
    void deleteRole(int id);

    /**
     *Metoda zapisująca rolę do tabeli
     * @param role Obiekt przeznaczony do zapisu do trabeli ról
     */
    void saveRole(Role role);

}
