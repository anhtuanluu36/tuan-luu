/**
 * 
 */
package com.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author tuanla
 *
 */
@Entity
@Table(name = "Student")  
public class Student {
	
	private Integer studentId;
	private String studentName;
	private Date birthday;
	
	@Id
	@GeneratedValue
    @Column(name = "StudentID") 
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	@Column(name = "StudentName")
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Column(name = "Birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}

