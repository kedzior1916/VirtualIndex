package com.projekt.wirtualny_indeks.index.controllers;

import com.projekt.wirtualny_indeks.index.controllers.commands.GradeFilter;
import com.projekt.wirtualny_indeks.index.controllers.commands.StudentFilter;
import com.projekt.wirtualny_indeks.index.models.*;
import com.projekt.wirtualny_indeks.index.services.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@Log4j2
public class StudentDetailController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private UserService userService;

    @ModelAttribute("searchCommand")
    public StudentFilter getSimpleSearch(){
        return new StudentFilter();
    }

    @RequestMapping(value ="/studentDetail.html",params = "student", method = {RequestMethod.GET, RequestMethod.POST})
    public String returnAllStudentsDetail(Model model, @Valid @ModelAttribute("searchCommand") StudentFilter search,Principal principal, boolean student)
    {

        model.addAttribute("allStudents", studentService.getAllStudents(search));
        model.addAttribute("allGrades", gradeService.getAllGrades());
        model.addAttribute("allSubjects",subjectService.getAllSubjects());
        model.addAttribute("student",false);
        if(student) {
            Student stud = studentService.getStudentByUsername(principal.getName());
            List<Grade> gradeList = gradeService.GetGradesByStudentId(stud.getId());
            Recruitment recruitment = recruitmentService.findByStudentId(stud.getId());
            Course course = recruitment.getCourse();
            List<Subject> subjectList = subjectService.getAllSubjectsByCourseId(course.getId());
            model.addAttribute("studentGrades", gradeList);
            model.addAttribute("course", course);
            model.addAttribute("subjectList",subjectList);
            for(Subject subject : subjectList)
            {
                log.info(subject.getId());
            }
            model.addAttribute("studentInfo",stud);
            model.addAttribute("student",true);
        }
        return "studentDetail";
    }

    @RequestMapping(value="/studentDetail.html", params = "all")
    public String resetGameList(@ModelAttribute("searchCommand") StudentFilter search, HttpSession session){
        search.clear();
        session.removeAttribute("wiadomosc");
        return "redirect:studentDetail.html?student=false";
    }

    @RequestMapping(value="/studentDetail.html")
    public String returnStudentById(Model model,Principal principal)
    {
        return "studentDetail";
    }





}
