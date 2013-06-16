/**
 * 
 */
package com.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


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
	private List<Fee> fees;
	private List<Course> courses;
	
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
	
	@OneToMany
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="StudentID", referencedColumnName="StudentID")
	@BatchSize(size = 10)
    public List<Fee> getFees() {
      return fees;
    }
    public void setFees(List<Fee> fees) {
      this.fees = fees;
    }
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
	    name="Course_Student",
	    joinColumns=@JoinColumn(name="StudentID"),
	    inverseJoinColumns=@JoinColumn(name="CourseID")
	)
    public List<Course> getCourses() {
        return this.courses;
    }
	
    public void setCourses(List<Course> courses) {
      this.courses = courses;
    }
}

