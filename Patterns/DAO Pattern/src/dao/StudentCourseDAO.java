package dao;

import java.sql.SQLException;
import java.util.List;

import models.StudentCourse;

public interface StudentCourseDAO {
	
	void addStudentCourse(StudentCourse studentCourse) throws SQLException;
	void updateStudentMarks(StudentCourse studentCourse) throws SQLException;
	void getStudentCourseById(Integer id) throws SQLException;
	List<StudentCourse> getStudentCourses() throws SQLException;

}
