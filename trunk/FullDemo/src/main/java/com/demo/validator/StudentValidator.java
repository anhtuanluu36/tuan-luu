package com.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.model.Student;

@Component
public class StudentValidator implements Validator{

  @Override
  public boolean supports(Class<?> clazz) {
    return Student.class.isAssignableFrom(clazz);   
  }

  @Override
  public void validate(Object arg0, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName", "name.required");
  }

}
