package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Course;
import com.demo.model.CourseStudentTotal;

@Repository
public class CourseDAO extends AbstractDAO<Course> {

  @SuppressWarnings("unchecked")
  public List<CourseStudentTotal> countCourseStudentTotal() {
    String sql = "SELECT NEW com.demo.model.CourseStudentTotal(c.courseName,c.students.size) FROM Course c";
    Query query = getSessionFactory().getCurrentSession().createQuery(sql);
    return query.list();
  }
}
