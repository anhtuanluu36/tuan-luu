/**
 * 
 */
package com.demo.converter;

import java.util.ArrayList;
import java.util.List;

import com.demo.dto.StudentDTO;
import com.demo.model.Student;

/**
 * @author TuanLA
 *
 */
public class StudentConverter {

	public static StudentDTO convertToDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(student.getStudentId());
		studentDTO.setStudentName(student.getStudentName());
		studentDTO.setBirthday(student.getBirthday());
		return studentDTO;
	}
	
	public static Student convertToEntity(StudentDTO studentDTO) {
		Student student = new Student();
		student.setStudentName(studentDTO.getStudentName());
		student.setBirthday(studentDTO.getBirthday());
		return student;
	}
	
	public static void mergeToEntity(final Student student, StudentDTO studentDTO) {
		student.setStudentName(studentDTO.getStudentName());
		student.setBirthday(studentDTO.getBirthday());
	}
	
	public static List<StudentDTO> convertToDTOs(List<Student> students) {
		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
		for (Student student : students) {
			studentDTOs.add(convertToDTO(student));
		}
		return studentDTOs;
	}
}
