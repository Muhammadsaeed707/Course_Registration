package hw1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface Admin_Interface {
	//abstract method declarations to create an interface
	public abstract Course createCourse (String course_Name, String course_Id, String maximum_Students, String instructor, String course_Section, String course_Location, ArrayList<Course> courses);
	
	public abstract void deleteCourse (ArrayList<Course> courses, String course_name);
	
	public abstract void editCourse (String courseName, String param, String var, ArrayList <Course> courses);
	
	public abstract void display (String course_Id, ArrayList <Course> courses);
	
	public static void register_student (ArrayList<Student> stu, String firstname, String lastname) {
		
	}
	
	public void viewAllCourses(ArrayList<Course> courses);
	
	public void View_Full_Courses(ArrayList<Course> courses);
	
	public abstract void write_full_courses(ArrayList<Course> courses) throws FileNotFoundException, UnsupportedEncodingException;
	
	public abstract void view_students_in_course(ArrayList <Course> courses, String course);
	
	public void viewStudentsCourses (String firstname, String lastname, ArrayList <Student> students);
	
	public abstract void Sort(ArrayList<Course> courses);
	
	
}
