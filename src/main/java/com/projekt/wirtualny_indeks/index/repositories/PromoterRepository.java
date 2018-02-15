package com.projekt.wirtualny_indeks.index.repositories;

import com.projekt.wirtualny_indeks.index.models.Promoter;
import com.projekt.wirtualny_indeks.index.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;




/** Repozytorium służące do zarządzania tabelą z Promotorami w bazie danych */
public interface PromoterRepository extends JpaRepository<Promoter,Integer> {

    /** Metoda mająca na celu zwrócenie promotora dla podanego Id studenta
     * @param id Id studenta
     * @return Zwraca promotora*/
    Promoter findByStudentsId(long id);

    /** Metoda mająca na celu zwrócenie listy promotorów dla danego id kursu
     * @param id Id kursu
     * @return Zwraca listę promotorów*/
    List<Promoter> findAllByCourseId(int id);
}
