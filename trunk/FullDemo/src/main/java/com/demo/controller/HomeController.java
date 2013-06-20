package com.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;
import com.demo.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class HomeController {

    @Autowired
    StudentService studentService;
    
	@RequestMapping(value="/list")
	public ModelAndView findAll(HttpServletResponse response) throws Exception{
	    ModelAndView model = new ModelAndView("home");
	    model.addObject("students", studentService.findAll());
		return model;
	}
	
	@RequestMapping(value="/ajax/list")
	@ResponseBody
    public Student find(@RequestBody Student student, HttpServletResponse response) throws Exception{
	    throw new Exception("avcac");
        //return student;
    }
}
