import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.StudentDAO;
import com.demo.exception.CustomException;
import com.demo.model.Student;


public class StudentDAOTest extends BaseTest {

  @Autowired
  StudentDAO studentDAO;
  
  @Test
  public void findAllUser() {
      final List<Student> students = studentDAO.findAll();
      System.out.println("UserDAOTest.findAllUser() " + students.size());
  }

  //@Test
  public void findByPrimaryKey() {
      Student student;
      try {
        student = studentDAO.findByPrimaryKey(1);
        System.out.println("StudentID: 1 - Fees: " + student);
      } catch (CustomException e) {
        e.printStackTrace();
      }
  }
}
