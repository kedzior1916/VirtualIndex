package com.projekt.wirtualny_indeks.index.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="recruitments")
@Getter
@Setter
@NoArgsConstructor
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Range(min = 30, max = 100, message = "Wynik matury musi być z przedziału 30-100")
    private double wynik1;

    @NotNull
    @Range(min = 30, max = 100, message = "Wynik matury musi być z przedziału 30-100")
    private double wynik2;

    private boolean enabled = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;
}
