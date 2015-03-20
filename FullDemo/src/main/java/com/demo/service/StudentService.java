/**
 * 
 */
package com.demo.service;

import java.util.List;

import com.demo.dto.StudentDTO;
import com.demo.exception.CustomException;
import com.demo.model.Student;

/**
 * @author tuanla
 *
 */

public interface StudentService {
	
	public List<Student> findAll();
	public List<Student> findAll(int firstResult, int pageSize);
	public Student findByPrimaryKey(int studentId) throws CustomException;
	public void saveOrUpdate(StudentDTO student) throws CustomException;
	public void delete(int studentId) throws CustomException;
}
