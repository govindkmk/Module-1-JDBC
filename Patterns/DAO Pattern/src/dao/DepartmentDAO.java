package dao;

import java.sql.SQLException;
import java.util.List;

import models.Department;

public interface DepartmentDAO {

	void addDepartment(Department department) throws SQLException;
	void updateDepartment(Department department)throws SQLException;
	void getDepartmentById(Integer id)throws SQLException;

	List<Department> getAllDepartments()throws SQLException;
	void deleteDepartment(Integer id)throws SQLException;
	
}
