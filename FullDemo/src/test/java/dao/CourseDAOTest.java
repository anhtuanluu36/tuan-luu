package dao;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.CourseDAO;
import com.demo.model.CourseStudentTotal;


public class CourseDAOTest extends DAOBaseTest {

  @Autowired
  CourseDAO courseDAO;
  
  @Test
  public void findAllUser() {
      final List<CourseStudentTotal> result = courseDAO.countCourseStudentTotal();
      //System.out.println("UserDAOTest.findAllUser() " + students.size());
      for (CourseStudentTotal temp : result) {
          System.out.println(temp.getCourseName() + "---" + temp.getTotal());
        }
  }
  
}
