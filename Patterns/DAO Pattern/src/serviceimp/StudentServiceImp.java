package serviceimp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import service.StudentService;
import dao.StudentDAO;
import daoimpl.StudentDAOImp;
import models.Department;
import models.Student;

public class StudentServiceImp implements StudentService{

	Scanner sc = new Scanner(System.in);
	
	StudentDAO studentDAO = new StudentDAOImp();
	
	int s_id, age, d_id;
	String name,fatherName, email, rollNumber;
	
	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Enter Student ID : ");
			s_id = sc.nextInt();
			sc.skip("\\R?");
			
			System.out.println("Enter Student Roll Number : ");
			rollNumber = sc.nextLine();
			
			System.out.println("Enter Student Name : ");
			name = sc.nextLine();
			
			
			System.out.println("Enter Student Father Name : ");
			fatherName = sc.nextLine();
			
			System.out.println("Enter Student Email : ");
			email = sc.nextLine();
			
			System.out.println("Enter Student Age : ");
			age = sc.nextInt();
			
			System.out.println("Enter Department Id : ");
			d_id = sc.nextInt();
			
			Student student = new Student();
			
			student.setId(s_id);
			student.setRollNumber(rollNumber);
			student.setName(name);
			student.setFatherName(fatherName);
			student.setAge(age);
			student.setEmail(email);
			
			Department department = new Department();
			department.setId(d_id);
			student.setDepartment(department);
			
			studentDAO.addStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Student ID : ");
			s_id = sc.nextInt();
			sc.skip("\\R?");
			
			System.out.println("Enter Student Roll Number for Update : ");
			rollNumber = sc.nextLine();
			
			System.out.println("Enter Student Name : ");
			name = sc.nextLine();
		
			
			System.out.println("Enter Student Father Name for Update : ");
			fatherName = sc.nextLine();
			
			System.out.println("Enter Student Email for Update : ");
			email = sc.nextLine();
			
			System.out.println("Enter Student Age for Update : ");
			age = sc.nextInt();
			
			System.out.println("Enter Department Id for Update : ");
			d_id = sc.nextInt();
			
			Student student1 = new Student();
			
			student1.setId(s_id);
			student1.setRollNumber(rollNumber);
			student1.setName(name);
			student1.setFatherName(fatherName);
			student1.setAge(age);
			student1.setEmail(email);
			
			Department department1 = new Department();
			department1.setId(d_id);
			student1.setDepartment(department1);
			
			studentDAO.updateStudent(student1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getStudentById() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Student ID : ");
			s_id = sc.nextInt();
			
			studentDAO.getStudentById(s_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getAllStudents() {
		// TODO Auto-generated method stub
		try {
			List<Student> students = studentDAO.getAllStudents();
			
			for(Student s : students) {
				System.out.println("\n***********************************");
				System.out.println("Id		: "+s.getId());
				System.out.println("Roll Number : "+s.getRollNumber());
				System.out.println("Name 	: "+s.getName());
				System.out.println("Father Name : "+s.getFatherName());
				System.out.println("Age 	: "+s.getAge());
				System.out.println("Email 	: "+s.getEmail());
				System.out.println("Department Name : "+s.getDepartment().getName());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Student Id : ");
			s_id = sc.nextInt();
			
			studentDAO.deleteStudent(s_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
