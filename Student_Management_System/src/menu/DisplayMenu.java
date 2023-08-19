package menu;

public class DisplayMenu {
	
	public void departmentMenu() {
	
		System.out.println("1. Add Department : ");
		System.out.println("2. Update Department : ");
		System.out.println("3. Get Department : ");
		System.out.println("4. Get all Departments : ");
		System.out.println("5. Delete Department : ");
	
	}
	
	public void courseMenu() {
		System.out.println("\n1. Add Course");
		System.out.println("2. Update Course");
		System.out.println("3. Get Course");
		System.out.println("4. Get all Courses");
		System.out.println("5. Delete Course\n");
	}

	public void studentMenu() {
		System.out.println("1. Add Student");
		System.out.println("2. Update Student");
		System.out.println("3. Get Student");
		System.out.println("4. Get all Students");
		System.out.println("5. Delete Students");
	}
	
	public void studentCourseMenu() {
		System.out.println("1. Assign Course to Student");
		System.out.println("2. Update Marks of Student");
		System.out.println("3. Get Student Courses");
		System.out.println("4. Get all Students Courses");
	}
}

