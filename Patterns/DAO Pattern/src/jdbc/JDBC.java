package jdbc;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import models.Course;
import models.Department;
import models.Student;
import models.StudentCourse;
import serviceimp.CourseServiceImp;
import serviceimp.DepartmentServiceImp;
import serviceimp.StudentCourseServiceImp;
import serviceimp.StudentServiceImp;


public class JDBC {
	
	public void display() {
		Scanner sc = new Scanner(System.in);
	
		
		System.out.println("1. Department Management System");
		System.out.println("2. Course Management System");
		System.out.println("3. Student Management System");
		System.out.println("4. Student Course Management System");
		
	
	}

	public static void main(String[] args) throws SQLException {
		
		JDBC jdbc = new JDBC();
		
		DepartmentServiceImp departmentServiceImp = new DepartmentServiceImp();
		CourseServiceImp courseServiceImp = new CourseServiceImp();
		StudentServiceImp studentServiceImp = new StudentServiceImp();
		StudentCourseServiceImp studentCourseServiceImp = new StudentCourseServiceImp();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n============Welcome Student Leaning Management System============\n");
		
		jdbc.display();
		
		int choice;
		System.out.println("\n\nPlease Select your choice : ");
		choice = sc.nextInt();
		
		char ch = 'y';
		
		do {
			switch(choice) {
			// Department CRUD
			case 1:
				while(ch == 'y') {
					//departmentDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
					switch(choice) {
					
					// Add Department 
					case 1:
						departmentServiceImp.addDepartment();
						break;
						
					// Update Department
					case 2:
						
						departmentServiceImp.updateDepartment();
						
						
						break;
						
					// Get Department by ID
					case 3:
						departmentServiceImp.getDepartmentById();
						
						
						break;
					
					// Get all Departments
					case 4:
						departmentServiceImp.getAllDepartments();
						break;
						
					// Delete Department
					case 5:
						departmentServiceImp.deleteDepartment();
						
						break;
					default:
						System.out.println("Invalid Choice...");	
					}
					
					System.out.println("\nDo you wanna Continue Department CRUD then press y other n : ");
					ch = sc.next().charAt(0);
				}
				break;
			// Course CRUD
			case 2:
				while(ch == 'y') {
					//courseDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
			
					switch(choice) {
					//add course
					case 1:
						courseServiceImp.addCourse();
						break;
						
					//update course
					case 2:
						courseServiceImp.updateCourse();
						break;
					
					//get course by id
					case 3:
						courseServiceImp.getCourseById();
						
						
						break;
					
					//get all courses
					case 4:
						courseServiceImp.getAllCourses();
						break;
					
					//delete course
					case 5:
						courseServiceImp.deleteCourse();
						break;
						
					default:
						System.out.println("Invalid Choice...");	
					}
					System.out.println("\nDo you wanna Continue Course CRUD then press y other n : ");
					ch = sc.next().charAt(0);
				}
				
				break;
			
			// Student CRUD
			case 3:
				while(ch == 'y') {
					//studentDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
					
					switch(choice) {
					//add Student
					case 1:
						studentServiceImp.addStudent();
						
						break;
						
					//update Student
					case 2:
						studentServiceImp.updateStudent();
						
						
						break;
						
					//get Student by ID
					case 3:
						studentServiceImp.getStudentById();
						break;
						
					//get all Students
					case 4:
						studentServiceImp.getAllStudents();
						break;
						
					//delete student
					case 5:
						studentServiceImp.deleteStudent();
						break;
						
					default:
						System.out.println("Invalid Choice...");
					}
				System.out.println("\nDo you wanna Continue Student CRUD then press y other n : ");
				ch = sc.next().charAt(0);
				}
				break;
				
				
			// Student Course CRUD
			case 4:
				while(ch == 'y'){
					//studentCourseDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
					
					switch(choice) {
					//add marks
					case 1:
						studentCourseServiceImp.addMarks();
						
					//update marks
					case 2:
						
						studentCourseServiceImp.updateMarks();
						break;
					
					//get student courses
					case 3:
						studentCourseServiceImp.getStudentCourseById();
						
						break;
					
					//get all students and courses
					case 4:
						studentCourseServiceImp.getAllStudentCourses();
					
						break;
						
					default:
						System.out.println("Invalid Choice...");
					}
					System.out.println("\nDo you wanna Continue Student Course CRUD then press y other n : ");
					ch = sc.next().charAt(0);
				}
				break;
			
			default:
				System.out.println("Invalid Choice...");	
			}
			
			System.out.println("\nDo you wanna Continue then press y other n : ");
			ch = sc.next().charAt(0);
		}while(ch == 'y');
		
	}

}
