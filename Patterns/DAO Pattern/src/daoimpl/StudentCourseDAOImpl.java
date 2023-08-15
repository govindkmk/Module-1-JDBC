package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.StudentCourseDAO;
import dbconnection.DbConnection;
import models.Course;
import models.Student;
import models.StudentCourse;

public class StudentCourseDAOImpl implements StudentCourseDAO {

	public void display() {
		System.out.println("1. Assign Course to Student");
		System.out.println("2. Update Marks of Student");
		System.out.println("3. Get Student Courses");
		System.out.println("4. Get all Students Courses");
	}

	private final String INSERT_STUDENT_COURSE_QUERY = "INSERT INTO STUDENT_COURSE_DATA(s_ID, c_ID) VALUES(?,?); ";
	private final String UPDATE_MARKS_QUERY = "UPDATE STUDENT_COURSE_DATA obtained_marks = ? WHERE id = ?; ";
	private final String GET_STUDENT_COURSE_QUERY = "SELECT  s.s_name, c.c_name, scd.obtained_marks FROM STUDENT_COURSE_DATA scd INNER JOIN student s ON scd.s_ID = s.s_ID INNER JOIN COURSE c  ON scd.c_ID = c.c_ID WHERE scd.s_ID = ?; ";
	private final String GETALL_STUDENT_COURSE_QUERY = "SELECT  s.s_name, c.c_name, scd.obtained_marks FROM STUDENT_COURSE_DATA scd INNER JOIN student s ON scd.s_ID = s.s_ID INNER JOIN COURSE c  ON scd.c_ID = c.c_ID; ";
	
	
	
	public void addStudentCourse(StudentCourse studentCourse) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(INSERT_STUDENT_COURSE_QUERY);
		
		ps.setInt(1, studentCourse.getId());
		ps.setInt(2, studentCourse.getStudent().getId());
		ps.setInt(3, studentCourse.getCourse().getCourse_id());
		ps.setInt(4,studentCourse.getObtained_marks());
		
		ps.execute();

		System.out.println("Course has been Assigned to Student Successfully...");
	}
	
	public void updateStudentMarks(StudentCourse studentCourse) throws SQLException {

		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(UPDATE_MARKS_QUERY);
		
		ps.setInt(1, studentCourse.getObtained_marks());
		ps.setInt(2, studentCourse.getId());
		
		ps.executeUpdate();
		
		
		
		System.out.println("Student Marks has been updated successfully...");
		
	}
	
	public void getStudentCourseById(Integer id) throws SQLException {
		
		boolean bool = true;
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(GET_STUDENT_COURSE_QUERY);
		ps.setInt(1, id);
		ResultSet rst = ps.executeQuery();
		
		
		while(rst.next()) {
			if(bool == true) {
				System.out.println("		"+rst.getString("s.s_name")+"		");
				
				System.out.println("Course Name \t\t\t Marks");
				bool = false;
			}
			
			System.out.println(rst.getString("c.c_name")+"\t\t\t"+rst.getInt("scd.obtained_marks"));
			
		}
		
		
	
	}
	
	public List<StudentCourse> getStudentCourses() throws SQLException{
		Connection conn = DbConnection.getConnection();
		List<StudentCourse> studentCourses = new ArrayList<>();
		
		Statement statement = conn.createStatement();
		ResultSet rst = statement.executeQuery(GETALL_STUDENT_COURSE_QUERY);
		
		while(rst.next()) {
			StudentCourse studentCourse = new StudentCourse();
			Student student = new Student();
			Course course = new Course();
			
			studentCourse.setObtained_marks(rst.getInt("scd.obtained_marks"));
			student.setName(rst.getString("s.s_name"));
			course.setCourse_name(rst.getString("c.c_name"));
			
			
			studentCourse.setStudent(student);
			studentCourse.setCourse(course);
			
			studentCourses.add(studentCourse);
			
		}
		
		
		return studentCourses;
		
	}
}
