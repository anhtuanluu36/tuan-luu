/**
 * 
 */
package com.demo.service;

import java.util.List;

import com.demo.model.Student;

/**
 * @author tuanla
 *
 */

public interface StudentService {
	
	public List<Student> findAll();
	public List<Student> findAll(int firstResult, int pageSize);
	public Student findByPrimaryKey(int studentId);
	public void saveOrUpdate(Student student);
	public void delete(Student student);
}
