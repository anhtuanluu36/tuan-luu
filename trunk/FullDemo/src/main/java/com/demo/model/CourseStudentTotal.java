package com.demo.model;

public class CourseStudentTotal {
  private String courseName;
  private int total;
  
  public CourseStudentTotal(String courseName, int total) {
    this.courseName = courseName;
    this.total = total;
  }
  
  public String getCourseName() {
    return courseName;
  }
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  
  
}
