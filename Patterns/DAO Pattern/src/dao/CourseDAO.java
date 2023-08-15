package dao;

import java.sql.SQLException;
import java.util.List;

import models.Course;

public interface  CourseDAO {
	
	void addCourse(Course course) throws SQLException;
	void updateCourse(Course course) throws SQLException;
	void getCourseById(Integer id) throws SQLException;
	List<Course> getAllCourses() throws SQLException;
	void deleteCourse(Integer id) throws SQLException;

}
