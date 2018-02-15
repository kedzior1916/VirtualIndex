package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Recruitment;

import java.util.List;
/**Serwis służący do obslugi operacji na tabeli Recruitments*/
public interface RecruitmentService {
    /**
     *Metoda zwracająca liste wszystkich rekrutacji w tabeli
     * @return Zwraca listę rekrutacji
     */
    List<Recruitment> getAllRecruited();

    /**
     *Metoda zwracająca rekrutację o wybranym id studenta
     * @param id Id studenta
     * @return Zwraca listę rekrutacji studenta
     */
    List<Recruitment> getRecruitmetsByStudentId(Long id);

    /**
     *Metoda zwracająca rekrutację o wybranym id
     * @param id Id szukanej rekrutacji
     * @return Zwraca znalezioną rekrutację o danym id
     */
    Recruitment getRecruited(int id);

    /**
     *Metoda usuwająca rekrutację o wybranym id
     * @param id Id usuwanej rekrutacji
     */
    void deleteRecruited(int id);

    /**
     *Metoda zapisująca rekrutację do tabeli
     * @param recruitment Obiekt przeznaczony do zapisu do tabeli rekrutacji
     */
    void saveRecruited(Recruitment recruitment);

    /**
     *Metoda zwracająca rekrutację danego studenta
     * @param id Id studenta szukanej rekrutacji
     * @return Zwraca szukaną rekrutację o wybranym id studenta
     */
    Recruitment findByStudentId(long id);

    /**
     *Metoda zwracająca listę studentów którzy oczekują na zakończenie procesu rekrutacji
     * @return Zwraca listę rekrutacji
     */
    List<Recruitment> getUnchecked();

    /**
     *Metoda zwracająca listę studentów którzy zostali już zapisani na wybrany kierunek
     * @return Zwraca liste rekrutacji
     */
    List<Recruitment> getChecked();


    /**
     *Metoda zwracająca liste rekrutacji według id studenta i semestru
     * @param id Id studenta szukanej rekrutacji
     * @param semestr Semestr studenta szukanej rekrutacji
     * @return Zwraca liste rekturacji
     */
    List<Recruitment> findAllByCourseIdAndStudentSemestr(int id, int semestr);


}
