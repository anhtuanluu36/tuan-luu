/**
 * 
 */
package factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.model.Student;

/**
 * @author TuanLA
 *
 */
public class StudentFactory {
	
	public static Student buildStudent(int studentId) {
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentName("studentName_" + studentId);
		student.setBirthday(new Date());
		
		return student;
	}

	public static List<Student> buildStudentList(int... studentIds) {
		List<Student> students = new ArrayList<Student>();
		for (int studentId : studentIds) {
			students.add(buildStudent(studentId));
		}
		return students;
	}
}
