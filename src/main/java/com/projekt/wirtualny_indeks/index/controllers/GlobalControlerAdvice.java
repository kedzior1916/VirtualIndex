package com.projekt.wirtualny_indeks.index.controllers;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControlerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Model model, HttpServletRequest req, Exception ex) {
        model.addAttribute("exception", ex);
        model.addAttribute("url", req.getRequestURL());
        return "error";
    }

    @ExceptionHandler({JDBCConnectionException.class, DataIntegrityViolationException.class})
    public String handleDbError(Model model, HttpServletRequest req, Exception ex) {
        model.addAttribute("exception", ex);
        model.addAttribute("url", req.getRequestURL());
        return "error";
    }



}
