package com.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.dto.StudentDTO;

@Component
public class StudentValidator implements Validator{

  @Override
  public boolean supports(Class<?> clazz) {
    return StudentDTO.class.isAssignableFrom(clazz);   
  }

  @Override
  public void validate(Object arg0, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName", "name.required");
  }

}
