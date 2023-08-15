package serviceimp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.DepartmentDAO;
import daoimpl.DepartmentDAOImp;
import models.Department;
import service.DepartmentService;

public class DepartmentServiceImp implements DepartmentService{
	
	Scanner sc = new Scanner(System.in);
	int d_id;
	String name, code;
	
	DepartmentDAO departmentDAO = new DepartmentDAOImp();
	
	public void addDepartment() {
		
		try {
			System.out.println("Enter Department ID : ");
			d_id = sc.nextInt();
			sc.skip("\\R?");
			
			System.out.println("Enter Department Name : ");
			name = sc.nextLine();
			
			System.out.println("Enter Department Code : ");
			code = sc.next();

			Department dpt = new Department();
			dpt.setId(d_id);
			dpt.setName(name);
			dpt.setCode(code);
			
			departmentDAO.addDepartment(dpt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateDepartment() {
		
		
		try {
			System.out.println("Enter Department ID : ");
			d_id = sc.nextInt();
			sc.skip("\\R?");
			
			System.out.println("Enter Department Name for Update : ");
			name = sc.nextLine();
			
			
			System.out.println("Enter Department Code for Update : ");
			code = sc.nextLine();
			
			Department dpt1 = new Department();
			dpt1.setId(d_id);
			dpt1.setName(name);
			dpt1.setCode(code);
			
			departmentDAO.updateDepartment(dpt1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getDepartmentById() {
		
		try {
			System.out.println("Enter Department ID : ");
			d_id = sc.nextInt();
			
			departmentDAO.getDepartmentById(d_id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void getAllDepartments() {
		try {
			List<Department> departments = departmentDAO.getAllDepartments();
			
			for(Department d: departments) {
				System.out.println("\n***********************************");
				System.out.println("Id   : "+d.getId());
				System.out.println("Name : "+d.getName());
				System.out.println("Code : "+d.getCode());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteDepartment() {
		
		try {
			System.out.println("Enter Department ID : ");
			d_id = sc.nextInt();
			
			departmentDAO.deleteDepartment(d_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
