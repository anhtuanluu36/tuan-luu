package com.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.StudentDAO;
import com.demo.exception.CustomException;
import com.demo.model.Student;
import com.demo.service.StudentService;

@Service("studentService")
@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDAO studentDAO;

  @Override
  public List<Student> findAll() {
    return studentDAO.findAll();
  }

  @Override
  public void saveOrUpdate(Student student) {
    studentDAO.saveOrUpdate(student);
  }

  @Override
  public void delete(Student student) {
    studentDAO.delete(student);
  }

  @Override
  public List<Student> findAll(int firstResult, int pageSize) {
    return studentDAO.findAll(firstResult, pageSize);
  }

  @Override
  public Student findByPrimaryKey(int studentId) throws CustomException {
    return studentDAO.findByPrimaryKey(studentId);
  }
}
