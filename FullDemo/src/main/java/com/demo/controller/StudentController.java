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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.demo.converter.StudentConverter;
import com.demo.dto.StudentDTO;
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
    
    @PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/list")
	public ModelAndView showStudentListPage(HttpServletResponse response) throws Exception{
	    ModelAndView model = new ModelAndView("page.home");
	    model.addObject("students", findAll());
		return model;
	}
	
    @PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/ajax/list", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public List<StudentDTO> findAll() throws Exception{
        return StudentConverter.convertToDTOs(studentService.findAll());
    }
	
    @RequestMapping(value = "/ajax/list1", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseMessage find1(@Valid @RequestBody Student student, HttpServletResponse response) throws Exception {
        ResponseMessage message = new ResponseMessage("success", "aa", student);
        return message;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute StudentDTO studentDTO, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws CustomException {
      ModelAndView model = new ModelAndView("page.home");
      
      if ("error".equals(studentDTO.getStudentName())) {
    	  throw new CustomException("Test @ExceptionHandler");
      }
      if (bindingResult.hasErrors()) {
        model = new ModelAndView("page.home");
        List<FieldError> errors = bindingResult.getFieldErrors();
        StringBuffer customMessage = new StringBuffer();
        for (FieldError error : errors ) {
            customMessage.append(error.getObjectName() +"." + error.getField() +" "+ error.getCode()+"\n");
        }        
        model.addObject("errors", bindingResult.getAllErrors());
        return model;
      }
      studentDTO.setBirthday(new Date());
      studentService.saveOrUpdate(studentDTO);
      model.addObject("students", studentService.findAll());
      return model;
    }
    
    @RequestMapping(value = "/delete/{studentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage delete(@PathVariable Integer studentId) throws CustomException {
      if (studentId == null) {
    	  return new ResponseMessage("error", "student id must be required", studentId);
      }
      studentService.delete(studentId);
      return new ResponseMessage("success", "Deleted successfully!", studentId);
    }
    
    
    @RequestMapping(value = "/save-ajax", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseMessage saveAjax(@Valid @RequestBody StudentDTO studentDTO, BindingResult bindingResult) throws Exception {
        
        if (bindingResult.hasErrors()) {
          List<FieldError> errors = bindingResult.getFieldErrors();
          StringBuffer customMessage = new StringBuffer();
          for (FieldError error : errors ) {
              customMessage.append(error.getObjectName() +"." + error.getField() +" "+ error.getCode()+"\n");
          }        
          return new ResponseMessage("error", customMessage.toString(), studentDTO);
        }
        studentService.saveOrUpdate(studentDTO);
        return new ResponseMessage("success", "Save successfully!", studentDTO);
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
    
    @ExceptionHandler(CustomException.class)
    public ModelAndView handleCustomException(CustomException ex) {
    	 
		ModelAndView model = new ModelAndView("page.error");
		model.addObject("exception", ex);
		return model;
 
	}
	
	@InitBinder(value = "studentDTO")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.setValidator(validator);
    }
}
