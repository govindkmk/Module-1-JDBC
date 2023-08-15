package dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DbConnection;
import models.Department;

public class DepartmentDBManager {
	
	public void display() {
		System.out.println("1. Add Department : ");
		System.out.println("2. Update Department : ");
		System.out.println("3. Get Department : ");
		System.out.println("4. Get all Departments : ");
		System.out.println("5. Delete Department : ");
	}
	
	private final String INSERT_DEPARTMENT_QUERY = "INSERT INTO DEPARTMENT(d_ID, d_name, d_code) VALUES(?,?,?); ";
	private final String UPDATE_DEPARTMENT_QUERY = "update department set d_name = ?, d_code = ? WHERE d_ID = ?; ";
	private final String GET_DEPARTMENT_QUERY = "SELECT * FROM DEPARTMENT WHERE d_ID = ?; ";
	private final String GETALL_DEPARTMENT_QUERY = "SELECT * FROM DEPARTMENT; ";
	private final String DELETE_DEPARTMENT_QUERY = "DELETE FROM DEPARTMENT WHERE d_ID = ?; ";
	
	
	public void addDepartment(Department department) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		try {
			//set the values
			PreparedStatement ps = conn.prepareStatement(INSERT_DEPARTMENT_QUERY);
			
			ps.setInt(1,department.getId());
			ps.setString(2, department.getName());
			ps.setString(3, department.getCode());
			
			//execute the query
			
			ps.execute();
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Department "+department.getName()+" has been added...");
		
	}
	
	public void updateDepartment(Department department) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_DEPARTMENT_QUERY);
			
			ps.setString(1, department.getName());
			ps.setString(2, department.getCode());
			ps.setInt(3,department.getId());
			
			ps.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Department "+department.getName()+" has been updated...");
		
	}
	
	public void getDepartmentById(Integer id) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(GET_DEPARTMENT_QUERY);
		ps.setInt(1,id);
		
		ResultSet rst = ps.executeQuery();
		
		while(rst.next()) {
			System.out.println("Id	 : "+rst.getInt("d_ID"));
			System.out.println("Name : "+rst.getString("d_name"));
			System.out.println("Code : "+rst.getString("d_code"));
		}
		
		
		conn.close();
		
	}
	
	public List<Department> getAllDepartments() throws SQLException{
		
		Connection conn = DbConnection.getConnection();
		List<Department> departments = new ArrayList<>();
		
		
	    Statement statement = conn.createStatement();
	    ResultSet rst = statement.executeQuery(GETALL_DEPARTMENT_QUERY);
	    
		
		while(rst.next()) {
			Department department = new Department();
			department.setId(rst.getInt("d_ID"));
			department.setName(rst.getString("d_name"));
			department .setCode(rst.getString("d_code"));
			
			departments.add(department);
			
		}
		conn.close();
		
		
		return departments;
		
	}
	
	public void deleteDepartment(Integer id) throws SQLException {
	
		 Connection conn = DbConnection.getConnection();
		 
		 PreparedStatement ps = conn.prepareStatement(DELETE_DEPARTMENT_QUERY);
		  
		 
		  
		 ps.setInt(1, id); 
		 
		  
		 ps.executeUpdate();
		  
		 conn.close();
		  
		 System.out.println("Department has been deleted successfully...");
		 

		
		
	}

}














