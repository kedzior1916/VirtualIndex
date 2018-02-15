package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.controllers.commands.GradeFilter;
import com.projekt.wirtualny_indeks.index.models.Grade;
import com.projekt.wirtualny_indeks.index.models.Student;
import com.projekt.wirtualny_indeks.index.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrades(GradeFilter phrase) {
        if(phrase.isEmpty())
        {
            return gradeRepository.findAll();
        }else
        {
            return gradeRepository.findAllGradesUsingFilter(phrase.getPhraseLIKE());
        }
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }


    @Override
    public Grade getGrade(int id) {
        return gradeRepository.findById(id).get();
    }

    @Override
    public List<Grade> GetGradesByStudentId(long id)
    {
        return gradeRepository.findAllGradesByStudentId(id);
    }

    @Override
    public void deleteGrade(int id) {
        gradeRepository.deleteById(id);

    }

    @Override
    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);

    }

    @Override
    public List<Grade> findAllByTermin(int termin) {
        return gradeRepository.findAllByTermin(termin);
    }


}
