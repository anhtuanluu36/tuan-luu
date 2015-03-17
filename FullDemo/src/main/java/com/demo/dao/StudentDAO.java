package com.demo.dao;

import java.util.List;

import com.demo.exception.CustomException;
import com.demo.model.Student;

public interface StudentDAO {
	List<Student> findAll();
	
	List<Student> findAll(int firstResult, int pageSize);
	
	void saveOrUpdate(Student student);
	
	void delete(Student student);
	
	Student findByPrimaryKey(Integer studentId) throws CustomException;
}
