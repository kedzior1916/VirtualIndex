package com.projekt.wirtualny_indeks.index.controllers;

import com.projekt.wirtualny_indeks.index.models.Course;
import com.projekt.wirtualny_indeks.index.repositories.CourseRepository;
import com.projekt.wirtualny_indeks.index.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CourseFormController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courseForm.html")
    public String showCourseForm(Model model, Optional<Integer> id) {
        model.addAttribute("Course",
                id.isPresent()?
                        courseService.getCourse(id.get()):
                        new Course());
        return "courseForm";
    }

    @PostMapping("/courseForm.html")
    public String processCourseForm(@Valid @ModelAttribute("Course") Course course, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "courseForm";
        }
        courseService.saveCourse(course);

        return "redirect:courseList.html";
    }
}
