package hw1;

import java.util.*;

public class Student extends User implements Student_Interface {
	ArrayList<String> Courses = new ArrayList<String>();
	
	//arg and no arg constructors
	public Student (String username, String password, String fname, String lname) {
		super (username, password, fname, lname);
	}
	
	public Student () {
		super ();
	}
	
	//options
	public void View_Student_Choices() {
		System.out.println("1. View all courses.");
		System.out.println("2. View all courses that are not FULL.");
		System.out.println("3. Register for a course.");
		System.out.println("4. Withdraw from a course.");
		System.out.println("5. View all current courses.");
		System.out.println("6. Exit.");
	}
	
	//view courses
	public void viewAllCourses (ArrayList <Course> courses) {
		for (int i = 0; i < courses.size(); i++) {
			Course c = courses.get(i);		
			System.out.println(c.getCourse_Name());	
		}		
	}
	
	//view courses that are not full
	public void viewNotFullCourses(ArrayList<Course> courses) {
		System.out.println("The availbale courses are: ");
		for (int i = 0; i < courses.size(); i++) {
			Course c = courses.get(i);		
			if (c.getCurrent_Students() < c.getMaximum_Students()) {
				System.out.println(c.getCourse_Name());
			}
		}
	}
	
	//register in a class
	public void register(Student name,  ArrayList <Course> courses, String course, String section) {
		for (int i = 0; i < courses.size(); i++) {
			Course c = courses.get(i);			
			if (c.getCourse_Name().toLowerCase().equals(course.toLowerCase()) && c.getCourse_Section().equals(section)) {
				Courses.add(course);
				c.add_Student(name);	
			}
		}
	}
	
	//withdraw if a class is already full
	public void withdraw(String course) {
		Courses.remove(course);
	}
	
	//withdraw from a class
	public void WithDraw_Courses(ArrayList <Course> courses, Student s, String course, String section) {
		for (int i = 0; i < courses.size(); i++) {
			Course d = courses.get(i);
			if (d.getCourse_Name().equals(course) && d.getCourse_Section().equals(section)) {
				d.delete_Student(s);
				Courses.remove(course);
			}
		}
		System.out.println("You have succesfully withdrawn from the course.");
	}
	
	public void getCourses() {
		System.out.println(this.getFirstName() + " " + this.getLastName() + " is enrolled in these courses:");

		for (String x: this.Courses) {
			System.out.println(x);
		}
	}
}
