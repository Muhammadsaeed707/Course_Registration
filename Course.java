package hw1;

import java.util.ArrayList;
import java.io.Serializable;

public class Course implements Serializable {
	//declare vars
	private String Course_Name;
	private String Course_Id;
	private int Maximum_Students;
	private String Instructor;
	private String Course_Section;
	private String Course_Location;
	
	private ArrayList <Student> Student_Names = new ArrayList<Student>();
	private int Current_Students = 0;
	
	//arg and no arg constructor 
	public Course (String course_Name, String course_Id, String maximum_Students, 
			String current_Students, String instructor, String course_Section, String course_Location) {
		Course_Name = course_Name;
		Course_Id = course_Id;
		Maximum_Students = Integer.parseInt(maximum_Students);
		Current_Students = Integer.parseInt(current_Students);
		Instructor = instructor;
		Course_Section = course_Section;
		Course_Location = course_Location;	
	}

	public Course() {
		
	}

	//getters and setters
	public String getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}

	public String getCourse_Id() {
		return Course_Id;
	}

	public void setCourse_Id(String course_Id) {
		Course_Id = course_Id;
	}

	public int getMaximum_Students() {
		return Maximum_Students;
	}

	public void setMaximum_Students(String maximum_Students) {
		Maximum_Students = Integer.parseInt(maximum_Students);
	}

	public String getInstructor() {
		return Instructor;
	}

	public void setInstructor(String instructor) {
		Instructor = instructor;
	}

	public String getCourse_Section() {
		return Course_Section;
	}

	public void setCourse_Section(String course_Section) {
		Course_Section = course_Section;
	}
	
	public String getCourse_Location() {
		return Course_Location;
	}

	public void setCourse_Location(String course_Location) {
		Course_Location = course_Location;
	}
	
	public int getCurrent_Students() {
		return Current_Students;
	}

	public void setCurrent_Students(String current_Students) {
		Current_Students = Integer.parseInt(current_Students);
	}
	
	public ArrayList<Student> getStudent_Names() {
		return this.Student_Names;
	}
	
	public ArrayList<Student> viewStudent_Names() {
		return this.Student_Names;
	}

	//add student to a course
	public void add_Student(Student student_Names) {
		if (this.Current_Students < this.getMaximum_Students()) {
		Student_Names.add(student_Names);
		Current_Students ++;
		System.out.println("You have registered in the class sucessfully.");
		}
		else {
			student_Names.withdraw(this.Course_Name);
			System.out.println("Sorry this course is full.");
		}
	}
	
	//delete student from a course
	public void delete_Student(Student student_Names) {
		this.Student_Names.remove(student_Names);
		Current_Students --;
	}
}
