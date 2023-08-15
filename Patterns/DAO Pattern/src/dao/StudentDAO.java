package dao;

import java.sql.SQLException;
import java.util.List;

import models.Student;

public interface StudentDAO {
	
	void addStudent(Student student)throws SQLException;
	void updateStudent(Student student) throws SQLException;
	void getStudentById(Integer id) throws SQLException;
	List<Student> getAllStudents() throws SQLException;
	void deleteStudent(Integer id) throws SQLException;

}
