package hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.*;

public class Admin extends User implements Admin_Interface {
	private String user = "Admin";
	private String pass = "Admin001";
	public ArrayList <Student> All_Students;
	
	public void View_CourseManagement() {
		//options
		System.out.println("1. Create a new Course.");
		System.out.println("2. Delete a  Course.");
		System.out.println("3. Edit a Course.");
		System.out.println("4. Display information for a given course.");
		System.out.println("5. Register a student.");
		System.out.println("6. Exit.");
	}
	
	//create course given course parameters
	public Course createCourse (String course_Name, String course_Id, String maximum_Students, String instructor, String course_Section, String course_Location, ArrayList<Course> courses) {
		String current_Students = "0";
		
		Course c = new Course(course_Name, course_Id, maximum_Students, current_Students, instructor, course_Section, course_Location);
		courses.add(c);
		return c;
	}
	
	//delete a course given name from arraylist
	public void deleteCourse (ArrayList<Course> courses, String course_name) {
		for (int i = 0; i < courses.size(); i++) {
			Course delete = courses.get(i);
			if (delete.getCourse_Name().toLowerCase().equals(course_name.toLowerCase())) {
				courses.remove(delete);	
			}
		}
	}
	
	//edit a course for certain parameter given name 
	public void editCourse (String courseName, String param, String var, ArrayList <Course> courses) {
		for (int i = 0; i < courses.size(); i++) {
			
			Course edit = courses.get(i);
			
			if (param.equals("max students")) {
				if (edit.getCourse_Name().toLowerCase().equals(courseName.toLowerCase())) {
					edit.setMaximum_Students(var);					
				}
			}
			
			else if (param.equals("instructor")) {
				if (edit.getCourse_Name().toLowerCase().equals(courseName.toLowerCase())) {
					edit.setInstructor(var);					
				}
			}
			
			else if (param.equals("course section")) {
				if (edit.getCourse_Name().toLowerCase().equals(courseName.toLowerCase())) {
					edit.setCourse_Section(var);					
				}
			}
			
			else if (param.equals("course location")) {
				if (edit.getCourse_Name().toLowerCase().equals(courseName.toLowerCase())) {
					edit.setCourse_Location(var);				
				}
			}
		}
	}
	
	//display a courses details given course id
	public void display (String course_Id, ArrayList <Course> courses) {
		for (int i = 0; i < courses.size(); i++) {
			Course dis = courses.get(i);

			if (dis.getCourse_Id().toLowerCase().equals(course_Id.toLowerCase())) {
				System.out.println("This is the information for Course: " + dis.getCourse_Id());
				System.out.println("Course name: " + dis.getCourse_Name());
				System.out.println("Course location: " + dis.getCourse_Location());
				System.out.println("Course section: " + dis.getCourse_Section());
				System.out.println("Course Instructor: " + dis.getInstructor());
				System.out.println("Current Number of Students: " + dis.getCurrent_Students());
				System.out.println("Maximum Students: " + dis.getMaximum_Students());
				
				System.out.println("Student Names: ");
				for (Student names: dis.viewStudent_Names()) {
					System.out.println(names.getFirstName() + " " + names.getLastName());
				}
			}
		}
	}
	
	//register a student, giving them a username and password
	public void register_student (ArrayList<Student> stu, String firstname, String lastname) {
		Random rand = new Random();

		String username = firstname.toLowerCase() + rand.nextInt(100);		
		String password =  lastname.toLowerCase() + rand.nextInt(100);
		
		Student student = new Student(username, password, firstname, lastname);
		stu.add(student);
		
		System.out.println("The username is " + username);
		System.out.println("The password is " + password);
	}
	
	//reports options
	public void View_Reports() {
		System.out.println("1. View all courses.");
		System.out.println("2. View all courses that are FULL.");
		System.out.println("3. Write to a file the list of course that are fullL.");
		System.out.println("4. View the names of the students that are registered in a specific course.");
		System.out.println("5. View the list of courses that a given student is registered in.");
		System.out.println("6. Sort the courses based on the current number of students registered.");
		System.out.println("7. Exit.");
	}
	
	public void viewAllCourses(ArrayList<Course> courses) {
		boolean g = true;
		for (int i = 0; i < courses.size(); i++) {
			Course view = courses.get(i);
			ArrayList<Student> stu = view.getStudent_Names();
			for (Student f: stu) {
				System.out.println("Enrolled students are: " + f.getFirstName() + " " + f.getLastName());
				g = false;
			}
			System.out.println("Current number of students is " + view.getCurrent_Students());
			System.out.println("Max students are " + view.getMaximum_Students());
			System.out.println(" ");
		}
		if (g == true) {
			System.out.println("There are no students in this course.");
		}
	}
	
	
	//view courses that are full 
	public void View_Full_Courses(ArrayList<Course> courses) {
		boolean t = true;
		System.out.print("The full courses are: ");		
		for (int i = 0; i < courses.size(); i++) {
			Course view = courses.get(i);			
			if (view.getCurrent_Students() == view.getMaximum_Students()) {
				System.out.println(view.getCourse_Name());
				t = false;
			}
		}
		if (t == true) {	
			System.out.println("There are no full courses.");
		}
	}
	
	//write file for full courses
	public void write_full_courses(ArrayList<Course> courses) throws FileNotFoundException, UnsupportedEncodingException {
			PrintWriter witer = new PrintWriter ("FullCourses.txt", "UTF-8");
			for (int i = 0; i < courses.size(); i++) {
				Course write = courses.get(i);
				if (write.getCurrent_Students() == write.getMaximum_Students()) {
					witer.println(write.getCourse_Name());
				}
			}
			witer.close();
		}
		
	
	//view students in a given course given the course
	public void view_students_in_course(ArrayList <Course> courses, String course) {
			boolean g = true;
			System.out.println("These are the students registered in the course.");
			
			for (int i = 0; i < courses.size(); i ++) {
				Course c = courses.get(i);
				if (c.getCourse_Name().toLowerCase().equals(course.toLowerCase())) {
					ArrayList<Student> stu = c.getStudent_Names();
					for (Student f: stu) {
						System.out.println(f.getFirstName() + " " + f.getLastName());
						g = false;
					}
				}
			}
			if (g == true) {
				System.out.println("There are no students in this course.");
			}
	}
	
	//view particular students courses
	public void viewStudentsCourses (String firstname, String lastname, ArrayList <Student> students) {
		for (Student s : students) {		
			String fname = s.getFirstName();
			String lname = s.getLastName();	
			if (fname.toLowerCase().equals(firstname.toLowerCase()) && lname.toLowerCase().equals(lastname.toLowerCase())) {		
				s.getCourses();		
			}			
		}
	}
	
	//sort courses based on registered students 
	public void Sort(ArrayList<Course> courses) {
		ArrayList<Integer>  list = new ArrayList<Integer>();
		ArrayList<Course> list2 = new ArrayList<Course>();
		ArrayList<String> list3 = new ArrayList<String>();

		for (int i = 0 ; i < courses.size(); i ++) {
			Course g = courses.get(i);
			list.add(g.getCurrent_Students());
			list2.add(g);
		}
	
		Collections.sort(list);
		for (int h: list) {
			for (int i = 0;  i < list2.size(); i ++) {
				Course f = list2.get(i);
				if (f.getCurrent_Students() == h) {
					list3.add(f.getCourse_Name() + ":  " + f.getCurrent_Students() + " students" );
					list2.remove(f);
				}
			}
		}
		System.out.println("These are the sorted courses based on the registered students where the course with the most students at the bottom:");
		for (String g: list3) {
			System.out.println(g);
		}
	}
}
