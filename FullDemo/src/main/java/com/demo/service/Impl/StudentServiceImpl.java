package com.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.converter.StudentConverter;
import com.demo.dao.StudentDAO;
import com.demo.dto.StudentDTO;
import com.demo.exception.CustomException;
import com.demo.model.Student;
import com.demo.service.StudentService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDAO studentDAO;

  @Override
  public List<Student> findAll() {
    return studentDAO.findAll();
  }

  @Override
  public void saveOrUpdate(StudentDTO studentDTO) throws CustomException {
	Student student = null;
	if (studentDTO.getStudentId() != null) {
		student = studentDAO.findByPrimaryKey(studentDTO.getStudentId());
		StudentConverter.mergeToEntity(student, studentDTO);
	} else {
		student = StudentConverter.convertToEntity(studentDTO);
	}
    studentDAO.saveOrUpdate(student);
  }

  @Override
  public void delete(int studentId) throws CustomException {
	Student student = studentDAO.findByPrimaryKey(studentId);
    studentDAO.delete(student);
  }

  @Override
  public List<Student> findAll(int firstResult, int pageSize) {
    return studentDAO.findAll(firstResult, pageSize);
  }

  @Override
  public Student findByPrimaryKey(int studentId) throws CustomException {
    Student student = studentDAO.findByPrimaryKey(studentId);
    return student;
  }
}
