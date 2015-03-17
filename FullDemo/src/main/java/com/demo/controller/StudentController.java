package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.demo.exception.CustomException;
import com.demo.message.ResponseMessage;
import com.demo.model.Student;
import com.demo.service.StudentService;
import com.demo.validator.StudentValidator;

@Controller
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    @Autowired
    StudentValidator validator;
    
	@RequestMapping(value="/list")
	public ModelAndView findAll(HttpServletResponse response) throws Exception{
	    ModelAndView model = new ModelAndView("home");
	    model.addObject("students", studentService.findAll());
		return model;
	}
	
	@RequestMapping(value="/ajax/list", produces = "application/json;charset=UTF-8")
	@ResponseBody
    public Student find(@RequestBody Student student, BindingResult errors, HttpServletResponse response) throws Exception{
        return student;
    }
	
    @RequestMapping(value = "/ajax/list1", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseMessage find1(@Valid @RequestBody Student student, HttpServletResponse response) throws Exception {
        ResponseMessage message = new ResponseMessage("success", "aa", student);
        return message;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute Student student, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws CustomException {
      ModelAndView model = new ModelAndView("home");
      
      if (bindingResult.hasErrors()) {
        model = new ModelAndView("home");
        List<FieldError> errors = bindingResult.getFieldErrors();
        StringBuffer customMessage = new StringBuffer();
        for (FieldError error : errors ) {
            customMessage.append(error.getObjectName() +"." + error.getField() +" "+ error.getCode()+"\n");
        }        
        model.addObject("errors", bindingResult.getAllErrors());
        return model;
      }
      student = new Student();
      student.setStudentName("asdd");
      student.setBirthday(new Date());
      //student.setVersion(1l);
      studentService.saveOrUpdate(student);
      model.addObject("students", studentService.findAll());
      return model;
    }
    
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        StringBuffer customMessage = new StringBuffer();
        for (FieldError error : errors ) {
            customMessage.append(error.getObjectName() +"." + error.getField() +" "+ error.getCode()+"\n");
        }        
        return customMessage.toString();
    }
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.setValidator(validator);
    }
}
