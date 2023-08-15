package serviceimp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import service.StudentCourseService;
import dao.StudentCourseDAO;
import daoimpl.StudentCourseDAOImpl;
import models.Course;
import models.Student;
import models.StudentCourse;

public class StudentCourseServiceImp implements StudentCourseService{

	Scanner sc = new Scanner(System.in);
	
	StudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	
	int id, s_id, c_id, obtained_marks;
	
	@Override
	public void addMarks() {
		// TODO Auto-generated method stub
		
		try {
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
			
			studentCourseDAO.addStudentCourse(studentCourse);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateMarks() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter ID : ");
			id = sc.nextInt();
			sc.skip("\\R?");
			
			System.out.println("Enter Obtained Marks for Update: ");
			obtained_marks = sc.nextInt();
			
			StudentCourse studentCourse1 = new StudentCourse();
			studentCourse1.setId(id);
			studentCourse1.setObtained_marks(obtained_marks);
			
			studentCourseDAO.updateStudentMarks(studentCourse1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getStudentCourseById() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Student ID : ");
			s_id = sc.nextInt();
			
			studentCourseDAO.getStudentCourseById(s_id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getAllStudentCourses() {
		// TODO Auto-generated method stub
		try {
			List<StudentCourse> student_Courses = studentCourseDAO.getStudentCourses();
			
			
			for(StudentCourse stdcrs : student_Courses) {
				
					System.out.println("\n***********************************");
					
					System.out.println("		"+stdcrs.getStudent().getName()+"		");
					System.out.println("Course Name \t \t Marks");
				
					System.out.println(stdcrs.getCourse().getCourse_name()+"\t\t"+stdcrs.getObtained_marks());
			
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
