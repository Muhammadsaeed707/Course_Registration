package hw1;

import java.util.ArrayList;

public interface Student_Interface {
	public abstract void viewAllCourses (ArrayList <Course> courses);
	
	public abstract void viewNotFullCourses(ArrayList<Course> courses);
	
	public abstract void register(Student name, ArrayList <Course> courses, String course, String section);
	
	public abstract void withdraw(String course);
	
	public abstract void WithDraw_Courses(ArrayList <Course> courses, Student s, String course, String section);
	
	public abstract void getCourses();
}

