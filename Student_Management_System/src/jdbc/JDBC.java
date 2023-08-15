package jdbc;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import models.Course;
import models.Department;
import models.Student;
import models.StudentCourse;
import dbmanager.CourseDbManager;
import dbmanager.DepartmentDBManager;
import dbmanager.StudentCourseDbManager;
import dbmanager.StudentDbManager;
import dbconnection.DbConnection;

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
		
		DepartmentDBManager departmentDbManager = new DepartmentDBManager();
		CourseDbManager courseDbManager = new CourseDbManager();
		StudentDbManager studentDbManager = new StudentDbManager();
		StudentCourseDbManager studentCourseDbManager = new StudentCourseDbManager();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n============Welcome Student Leaning Management System============\n");
		
		jdbc.display();
		
		int choice;
		System.out.println("\n\nPlease Select your choice : ");
		choice = sc.nextInt();
		
		int id, d_id, s_id, c_id, age, obtained_marks;
		String name, code, fatherName, email, rollNumber;
		
		char ch = 'y';
		
		do {
			switch(choice) {
			// Department CRUD
			case 1:
				while(ch == 'y') {
					departmentDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
					switch(choice) {
					
					// Add Department 
					case 1:
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
						
						departmentDbManager.addDepartment(dpt);
						break;
						
					// Update Department
					case 2:
						
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
						
						departmentDbManager.updateDepartment(dpt1);
						
						
						break;
						
					// Get Department by ID
					case 3:
						System.out.println("Enter Department ID : ");
						d_id = sc.nextInt();
						
						
						departmentDbManager.getDepartmentById(d_id);;
						
						
						break;
					
					// Get all Departments
					case 4:
						List<Department> departments = departmentDbManager.getAllDepartments();
						
						for(Department d: departments) {
							System.out.println("\n***********************************");
							System.out.println("Id   : "+d.getId());
							System.out.println("Name : "+d.getName());
							System.out.println("Code : "+d.getCode());
							
						}
						break;
						
					// Delete Department
					case 5:
						System.out.println("Enter Department ID : ");
						d_id = sc.nextInt();
						
						
						departmentDbManager.deleteDepartment(d_id);
						
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
					courseDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
			
					switch(choice) {
					case 1:
						System.out.println("Enter Course ID : ");
						c_id = sc.nextInt();
						sc.skip("\\R?");
						
						System.out.println("Enter Course Name : ");
						name = sc.nextLine();
						
						System.out.println("Enter Course Code : ");
						code = sc.next();
						
						Course course = new Course();
						course.setCourse_id(c_id);
						course.setCourse_name(name);
						course.setCourse_code(code);
						
						courseDbManager.addCourse(course);
						break;
						
					case 2:
						System.out.println("Enter Course ID : ");
						c_id = sc.nextInt();
						sc.skip("\\R?");
						
						System.out.println("Enter Course Name : ");
						name = sc.nextLine();
						
						System.out.println("Enter Course Code : ");
						code = sc.nextLine();
						
						Course course1 = new Course();
						course1.setCourse_id(c_id);
						course1.setCourse_name(name);
						course1.setCourse_code(code);
						
						courseDbManager.updateCourse(course1);
						break;
						
					case 3:
						System.out.println("Enter Course ID : ");
						c_id = sc.nextInt();
						
						courseDbManager.getCourseById(c_id);
						
						
						break;
					
					case 4:
						List<Course> courses = courseDbManager.getAllCourses();
						
						for(Course c : courses) {
							System.out.println("\n***********************************");
							System.out.println("Id   : "+c.getCourse_id());
							System.out.println("Name : "+c.getCourse_name());
							System.out.println("Code : "+c.getCourse_code());
							
						}
						break;
						
					case 5:
						System.out.println("Enter Course ID : ");
						c_id = sc.nextInt();
						
						courseDbManager.deleteCourse(c_id);
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
					studentDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
					
					switch(choice) {
					case 1:
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
						
						studentDbManager.addStudent(student);
						
						
						break;
						
					case 2:
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
						
						studentDbManager.updateStudent(student1);
						
						
						break;
						
					case 3:
						System.out.println("Enter Student ID : ");
						s_id = sc.nextInt();
						
						studentDbManager.getStudentById(s_id);
						break;
						
					case 4:
						List<Student> students = studentDbManager.getAllStudents();
						
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
						break;
						
					case 5:
						System.out.println("Enter Student Id : ");
						s_id = sc.nextInt();
						
						studentDbManager.deleteStudent(s_id);
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
					studentCourseDbManager.display();
					System.out.println("\n\nPlease Select your choice : ");
					choice = sc.nextInt();
					
					switch(choice) {
					case 1:
						System.out.println("Enter Student ID : ");
						s_id = sc.nextInt();
						sc.skip("\\R?");
						
						System.out.println("Enter Course ID : ");
						c_id = sc.nextInt();
						
						System.out.println("Enter Obtained Marks : ");
						obtained_marks = sc.nextInt();
						
						Student student = new Student();
						student.getId();
						
						Course course = new Course();
						course.getCourse_id();
						
						StudentCourse studentCourse = new StudentCourse();
						studentCourse.setObtained_marks(obtained_marks);
						
						studentCourse.setStudent(student);
						studentCourse.setCourse(course);
						
						studentCourseDbManager.addStudentCourse(studentCourse);
						
						break;
						
					case 2:
						
						System.out.println("Enter ID : ");
						id = sc.nextInt();
						sc.skip("\\R?");
						
						System.out.println("Enter Obtained Marks for Update: ");
						obtained_marks = sc.nextInt();
						
						StudentCourse studentCourse1 = new StudentCourse();
						studentCourse1.setId(id);
						studentCourse1.setObtained_marks(obtained_marks);
						
						studentCourseDbManager.updateStudentMarks(studentCourse1);
						break;
						
					case 3:
						System.out.println("Enter Student ID : ");
						s_id = sc.nextInt();
						
						studentCourseDbManager.getStudentCourseById(s_id);
						
						break;
						
					case 4:
						List<StudentCourse> student_Courses = studentCourseDbManager.getStudentCourses();
						
						
						for(StudentCourse stdcrs : student_Courses) {
							
								System.out.println("\n***********************************");
								
								System.out.println("		"+stdcrs.getStudent().getName()+"		");
								System.out.println("Course Name \t \t Marks");
							
								System.out.println(stdcrs.getCourse().getCourse_name()+"\t\t"+stdcrs.getObtained_marks());
						
								
						}
					
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
