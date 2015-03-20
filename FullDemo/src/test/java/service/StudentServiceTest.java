/**
 * 
 */
package service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.StudentDAO;
import com.demo.model.Student;
import com.demo.service.StudentService;

import factory.StudentFactory;


/**
 * @author TuanLA
 *
 */
@Ignore
public class StudentServiceTest extends ServiceBaseTest {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentDAO studentDAO; 
	
	@Test
	public void testFindAll() {
		int random = (int)(100 * Math.random()) + 100;
		List<Student> expectedStudents = StudentFactory.buildStudentList(random, random + 1);
		
		Mockito.when(studentDAO.findAll()).thenReturn(expectedStudents);
		
		List<Student> result = studentService.findAll();
		Assert.assertEquals(expectedStudents.size(), result.size());
	}

}
