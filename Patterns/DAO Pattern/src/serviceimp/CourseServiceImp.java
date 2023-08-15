package serviceimp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import models.Course;
import service.CourseService;
import dao.CourseDAO;
import daoimpl.CourseDAOImp;

public class CourseServiceImp implements CourseService{

	Scanner sc = new Scanner(System.in);
	
	int c_id;
	String name, code;
	
	CourseDAO courseDAO = new CourseDAOImp();
	
	
	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		
		
		try {
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
			
			courseDAO.addCourse(course);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse() {
		// TODO Auto-generated method stub
		
		
		try {
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
			
			courseDAO.updateCourse(course1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getCourseById() {
		// TODO Auto-generated method stub
		
		
		try {
			System.out.println("Enter Course ID : ");
			c_id = sc.nextInt();
			
			courseDAO.getCourseById(c_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getAllCourses() {
		// TODO Auto-generated method stub
		
		try {
			List<Course> courses = courseDAO.getAllCourses();
			
			for(Course c : courses) {
				System.out.println("\n***********************************");
				System.out.println("Id   : "+c.getCourse_id());
				System.out.println("Name : "+c.getCourse_name());
				System.out.println("Code : "+c.getCourse_code());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Enter Course ID : ");
			c_id = sc.nextInt();
			
			courseDAO.deleteCourse(c_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
