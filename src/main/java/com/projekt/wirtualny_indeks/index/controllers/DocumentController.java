package com.projekt.wirtualny_indeks.index.controllers;

import com.projekt.wirtualny_indeks.index.controllers.commands.StudentFilter;
import com.projekt.wirtualny_indeks.index.models.*;
import com.projekt.wirtualny_indeks.index.services.*;
import com.projekt.wirtualny_indeks.index.utilities.PdfGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
public class DocumentController {

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private DocumentTypeService documentTypeService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/documents.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String getDocs(Model model)
    {
        model.addAttribute("allDocTypes",documentTypeService.getAllDocumentsTypes());
        return "documents";
    }


    @RequestMapping(value="/documentForm.html", method = RequestMethod.GET)
    public String docForm(Model model, @RequestParam("docId") int docId, @RequestParam("generate")boolean generate, Principal principal
    ,@Param("przedmiot1") String przedmiot1,@Param("przedmiot2") String przedmiot2,@Param("przedmiot3") String przedmiot3) throws Exception {

        User user = userService.getUserByName(principal.getName());
        Student student = studentService.getStudentByUserId(user.getId());

        Recruitment recruitment = recruitmentService.findByStudentId(student.getId());

        model.addAttribute("docId", docId);
        model.addAttribute("subjectList",
                subjectService.getAllSubjectsByCourseId(recruitment.getCourse().getId()));

        if(generate)
        {
            DocumentType documentType;
            Document document;
            Map<String,String> data;
            String prz1="";
            String prz2="";
            String prz3="";
            switch(docId){
                case 1:
                    documentType = documentTypeService.getDocumentType(docId);
                    document = new Document(0,user, documentType);
                    documentService.saveDocument(document);
                    document = documentService.getLastDocument();
                    log.info(document.getId());



                    if(przedmiot1!="pusty"){
                        prz1 = przedmiot1;
                    }

                    if(przedmiot2!="pusty"){
                        prz2 = przedmiot2;
                    }

                    if(przedmiot3!="pusty"){
                        prz3 = przedmiot3;
                    }

                    data = new HashMap<String,String>();
                    data.put("imie",student.getImie());
                    data.put("nazwisko",student.getNazwisko());
                    data.put("prz1",prz1);
                    data.put("prz2",prz2);
                    data.put("prz3",prz3);
                    pdfGenerator.createPdf("wk",data,document.getId());
                    return "redirect:myDocumentsList.html";

                case 2:
                    documentType = documentTypeService.getDocumentType(docId);
                    document = new Document(0,user, documentType);
                    documentService.saveDocument(document);
                    document = documentService.getLastDocument();
                    log.info(document.getId());

                    if(przedmiot1!="pusty"){
                        prz1 = przedmiot1;
                    }

                    data = new HashMap<String,String>();
                    data.put("imie",student.getImie());
                    data.put("nazwisko",student.getNazwisko());
                    data.put("prz1",prz1);
                    pdfGenerator.createPdf("wd",data,document.getId());
                    return "redirect:myDocumentsList.html";
            }
        }
        return "documentForm";
    }

    @RequestMapping(value="/myDocumentsList.html")
    public String myDocumentsList(Model model, Principal principal)
    {
        User user = userService.getUserByName(principal.getName());

        model.addAttribute("myDocuments",documentService.getAllDocumentsByUserId(user.getId()));
        return "myDocumentsList";
    }

    @RequestMapping(value="/documentsList.html")
    public String documentsList(Model model, @Valid @ModelAttribute("searchCommand") StudentFilter search){
        model.addAttribute("documentsList",documentService.getAllDocuments());
        model.addAttribute("students",studentService.getAllStudents(search));
        return "documentsList";
    }

    @RequestMapping(value="/documentAccept", method = RequestMethod.GET)
    public String documentAccept(@Param("docId") int docId)
    {
        Document document = documentService.getDocument(docId);
        document.setDocument_status(1);
        documentService.saveDocument(document);
        return "redirect:documentsList.html";
    }

    @RequestMapping(value="/documentDecline", method = RequestMethod.GET)
    public String documentDecline(@Param("docId") int docId)
    {
        Document document = documentService.getDocument(docId);
        document.setDocument_status(2);
        documentService.saveDocument(document);
        return "redirect:documentsList.html";
    }

    @RequestMapping(value = "/pdfDoc", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> downloadPDFFile(@Param("docId") int docId)
            throws IOException {

        ClassPathResource pdfFile = new ClassPathResource("templates/pdf/doc"+docId+".pdf");
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(pdfFile.contentLength())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }
}
