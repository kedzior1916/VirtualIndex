package com.projekt.wirtualny_indeks.index.validators;

import com.projekt.wirtualny_indeks.index.services.StudentService;
import com.projekt.wirtualny_indeks.index.services.UserService;
import com.projekt.wirtualny_indeks.index.validators.annotations.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private StudentService studentService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return studentService == null || (email != null && studentService.isUniqueEmail(email));
    }
}
