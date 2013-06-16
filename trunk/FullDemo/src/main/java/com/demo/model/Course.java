/**
 * 
 */
package com.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * @author tuanla
 *
 */
@Entity
@Table(name = "Course")  
public class Course {
    
    private Integer courseId;
    private String courseName;
    private List<Student> students;
    
    @Id
    @GeneratedValue
    @Column(name = "CourseID") 
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    
    @Column(name = "CourseName")
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    @ManyToMany(fetch=FetchType.LAZY,mappedBy="courses")
    public List<Student> getStudents() {
      return students;
    }
    public void setStudents(List<Student> students) {
      this.students = students;
    }
}

