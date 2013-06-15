/**
 * 
 */
package com.demo.model;

import java.util.Date;
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
    private Date birthday;
    
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
    
    @Column(name = "Birthday")
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }  
}

