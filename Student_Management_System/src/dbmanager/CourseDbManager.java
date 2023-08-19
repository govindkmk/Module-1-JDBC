package dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DbConnection;
import models.Course;

public class CourseDbManager {
	
	
	private final String INSERT_COURSE_QUERY = "INSERT INTO COURSE(c_ID, c_name, c_code) VALUES(?,?,?); ";
	private final String UPDATE_COURSE_QUERY = "UPDATE COURSE SET c_name = ?, c_code = ? WHERE c_ID = ?; ";
	private final String GET_COURSE_QUERY = "SELECT * FROM COURSE WHERE c_ID = ?; ";
	private final String GETALL_COURSES_QUERY = "SELECT * FROM COURSE; ";
	private final String DELETE_COURSE_QUERY = "DELETE FROM COURSE WHERE c_ID = ?; ";
	
	public void addCourse(Course course) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		// Set Values
		PreparedStatement ps = conn.prepareStatement(INSERT_COURSE_QUERY);
		ps.setInt(1, course.getCourse_id());
		ps.setString(2, course.getCourse_name());
		ps.setString(3,course.getCourse_code());
		
		// Execute Query
		ps.execute();
		conn.close();
		System.out.println("Course "+course.getCourse_name()+" has been added Successfully...");
		
	}
	
	public void updateCourse(Course course) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		// Set Values
		PreparedStatement ps = conn.prepareStatement(UPDATE_COURSE_QUERY);
		
		ps.setString(1, course.getCourse_name());
		ps.setString(2,course.getCourse_code());
		ps.setInt(2, course.getCourse_id());

		
		// Execute Query
		ps.execute();
		conn.close();
		System.out.println("Course "+course.getCourse_name()+" has been Updated Successfully...");
		
	}
	
	public void getCourseById(Integer id) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(GET_COURSE_QUERY);
		ps.setInt(1, id);
		
		ResultSet rst = ps.executeQuery();
		
		while(rst.next()) {
			System.out.println("Id   : "+rst.getInt("c_ID"));
			System.out.println("Name : "+rst.getString("c_name"));
			System.out.println("Code : "+rst.getString("c_code"));
		}
		
		conn.close();
		
	}
	
	public List<Course> getAllCourses() throws SQLException{
		Connection conn = DbConnection.getConnection();
		List<Course> courses = new ArrayList<>();
		
		Statement statement = conn.createStatement();
		ResultSet rst = statement.executeQuery(GETALL_COURSES_QUERY);
		
		while(rst.next()) {
			Course course = new Course();
			course.setCourse_id(rst.getInt("c_ID"));
			course.setCourse_name(rst.getString("c_name"));
			course.setCourse_code(rst.getNString("c_code"));
			courses.add(course);
			
		}
		conn.close();
		return courses;

		
	}
	
	public void deleteCourse(Integer id) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		// Set Values
		PreparedStatement ps = conn.prepareStatement(DELETE_COURSE_QUERY);
		ps.setInt(1, id);
		
		
		// Execute Query
		ps.executeUpdate();
		conn.close();
		System.out.println("Course has been Deleted Successfully...");

	}

}
