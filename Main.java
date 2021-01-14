package hw1;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
	public static void main (String[] args) throws IOException {
		//check if first time for serialization purposes
		Scanner input = new Scanner(System.in);
		System.out.print("Is this your first time using the system? Enter (y) or (n): ");
		String res1 = input.nextLine().toLowerCase();
		
		ArrayList <Course> CourseArray = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		//get the data from csv 
		if (res1.equals("y")) {
			Read_data r = new Read_data();
			String x;
			try {
				x = r.read();
				ArrayList <Course> CourseArray2 = Read_data.courseMaker(Read_data.arrayMaker(x));
				ArrayList<Student> students2 = new ArrayList<Student>();
				CourseArray = CourseArray2;
				students = students2;
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				//deserialize if not first time
				FileInputStream f = new FileInputStream("CourseArray.ser");
			    FileInputStream f2 = new FileInputStream("Student.ser");

			    ObjectInputStream o = new ObjectInputStream(f);
			    ObjectInputStream o2 = new ObjectInputStream(f2);

			    CourseArray = (ArrayList<Course>)o.readObject();
			    students = (ArrayList<Student>)o2.readObject();

			    o.close();
			    f.close();			      
			    o2.close();
			    f2.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
				return;
			}
			catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				return;
			}
		}
		boolean w = true;
		while (w) {
			//login for admin
			System.out.println("Welcome to the Course Registration System. Please enter if you are a student (s) or Admin (a): ");
			String s = input.nextLine().toLowerCase();
			boolean h = true;
			if (s.equals("a")) {
				
				System.out.println("Please Enter a Username");
				String username = input.nextLine();
				
				while (!username.equals("Admin")) {
					System.out.print("That is an invalid username.");
					System.out.println("Please Enter a Username");
					String username1 = input.nextLine();
					username = username1;
				}
				
				System.out.println("Please Enter a Password");
				String password = input.nextLine();
				while (!password.equals("Admin001")) {
					System.out.println("That was an incorrect password");
					System.out.println("Please Enter a Password");
					String password1 = input.nextLine();
					password = password1;
				}
				
				Admin admin = new Admin();
				while (h) {
					//admin options and method calls
					System.out.println("Welcome Admin. Here are your options:");
					System.out.println("For Course Management enter 'c'");
					System.out.println("For Reports enter 'r'");
					String l = input.nextLine();
					while (!l.equals("c") && !l.equals("r")) {
						System.out.println("For Course Management enter 'c'");
						System.out.println("For Reports enter 'r'");
						String l1 = input.nextLine();
						l = l1;
					}
					if (l.equals("c")) {
						admin.View_CourseManagement();
						System.out.println("Please enter the number of the selection you would like to do.");
						String choice = input.nextLine();
						if (choice.equals("1")) {
							System.out.println("Please give a course name.");
							String course_Name = input.nextLine();
							
							System.out.println("Please give a course ID.");
							String course_Id = input.nextLine();
							
							System.out.println("Please specify the maximum amount of students.");							
							String maximum_Students = input.nextLine();
							
							System.out.println("Please give the instructor.");							
							String instructor = input.nextLine();
							
							System.out.println("Please give the course section.");
							String course_Section = input.nextLine();
							
							System.out.println("Please give the course location.");
							String course_Location = input.nextLine();

							admin.createCourse(course_Name, course_Id, maximum_Students, instructor, course_Section, course_Location, CourseArray);
							System.out.println("The course was successfully created.");
						}
						if (choice.equals("2")){
							System.out.println("What course would you like to delete? Please give the course name.");
							String name = input.nextLine();
							admin.deleteCourse(CourseArray, name);
							System.out.println("The course was successfully deleted.");
						}
						if (choice.equals("3")){
							System.out.println("What course what you like to edit? Please give the course name.");
							String c_name = input.nextLine();
							
							System.out.println("What would you like to edit? Please enter max students, instructor, course section, course location");
							String param = input.nextLine();
							
							if (param.equals("max students")) {
								System.out.println("What would you like to change the max students to?");
								String var = input.nextLine();
								
								admin.editCourse(c_name, param, var, CourseArray);
							}
							
							else if (param.equals("instructor")) {
								System.out.println("What would you like to change the instructor's name to?");			
								String var = input.nextLine();
							
								admin.editCourse(c_name, param, var, CourseArray);
							}
							
							else if (param.equals("course section")) {
								System.out.println("What would you like to change the course section to?");			
								String var = input.nextLine();
							
								admin.editCourse(c_name, param, var, CourseArray);
							}
							
							else if (param.equals("course location")) {
								System.out.println("What would you like to change the course location to?");			
								String var = input.nextLine();
							
								admin.editCourse(c_name, param, var, CourseArray);
							}
						}
						if (choice.equals("4")){
							System.out.println("What course what you like to view? Please give the course ID.");
							String c_ID = input.nextLine();
							
							admin.display(c_ID, CourseArray );
						}
						if (choice.equals("5")) {
							System.out.println("Please enter the first name of the student");
							String firstname = input.nextLine();
							
							System.out.println("Please enter the last name of the student");
							String lastname = input.nextLine();
							
							admin.register_student(students, firstname, lastname );
						}
						if (choice.equals("6")) {
							w = false;
							h = false;
						}
					}
					else {
						//more admin options and method calls
						admin.View_Reports();
						System.out.println("Please enter the number of the selection you would like to do.");
						String choice = input.nextLine();
						if (choice.equals("1")) {
							admin.viewAllCourses(CourseArray);
						}
						if (choice.equals("2")) {
							admin.View_Full_Courses(CourseArray);
						}
						if (choice.equals("3")) {
							try {
								admin.write_full_courses(CourseArray);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("The file was succesfully created of full courses.");	
						}
						if (choice.equals("4")) {
							System.out.println("Please enter the Course Name you would like to see the student's of.");
							String course = input.nextLine();	
							
							boolean g = true;
							admin.view_students_in_course(CourseArray, course);
						}
						if (choice.equals("5")) {
							System.out.println("Please enter the Student's first name");
							String fname = input.nextLine();
							
							System.out.println("Please enter the Student's last name");							
							String lname = input.nextLine();
							
							admin.viewStudentsCourses(fname, lname, students);	
						}
						if (choice.equals("6")) {
							admin.Sort(CourseArray);
						}
						if (choice.equals("7")) {
							w = false;
							h = false;
						}
					}
				}
			}
			boolean f = true;
			if (s.equals("s")) {
				//student login 
				boolean c = true;
				while (c) {
					System.out.println("Please Enter a username.");
					String username1 = input.nextLine();
					for (Student stu: students) {
						String uname = stu.getUsername();				
						if (username1.equals(uname)) {
							c = false;
						}
					}
					if (c == true) {
						System.out.println("That was an incorrect username.");
					}	
				}
				Student Current_Student = new Student();
				while (!c) {
					System.out.println("Please Enter a password");
					String password1 = input.nextLine();
					for (Student stu: students  ) {				
						String pass = stu.getPassword();		
						if (password1.equals(pass)) {
							Current_Student = stu;
							c = true;	
						}
					}
					if (c == false) {	
						System.out.println("That was an incorrect password.");
					}
				}
				while (f) {
					//student options and method calls
					Current_Student.View_Student_Choices();
					String choice = input.nextLine();
					if (choice.equals("1")) {
						Current_Student.viewAllCourses(CourseArray);
					}
					if (choice.equals("2")) {
						Current_Student.viewNotFullCourses(CourseArray);
					}
					if (choice.equals("3")) {
						System.out.println("Please enter the course name.");
						String course = input.nextLine();
						
						System.out.println("Please enter the course section.");
						String section = input.nextLine();


						System.out.println("Please enter your first name.");
						String fname = input.nextLine();

						System.out.println("Please enter your last name.");
						String lname = input.nextLine();
						
						Current_Student.register(Current_Student, CourseArray, course, section);	
					}
					if (choice.equals("4")) {
						System.out.println("Please enter the course name.");
						String course = input.nextLine();
						
						System.out.println("Please enter the course section.");
						String section = input.nextLine();
						
						System.out.println("Please enter your first name.");
						String fname = input.nextLine();

						System.out.println("Please enter your last name.");
						String lname = input.nextLine();

						Current_Student.WithDraw_Courses(CourseArray, Current_Student, course, section);
					}
					if (choice.equals("5")) {
						Current_Student.getCourses();	
					}
					if (choice.equals("6")) {
						w = false;
						f = false;
					}
				}
			}
		}
		try {
			//serialize
			FileOutputStream CourseArray_Data = new FileOutputStream("CourseArray.ser");
			FileOutputStream student_Data = new FileOutputStream("Student.ser");

			ObjectOutputStream oos = new ObjectOutputStream(CourseArray_Data);
			ObjectOutputStream oos2 = new ObjectOutputStream(student_Data);
			
			oos2.writeObject(students);
			oos.writeObject(CourseArray);

			oos.close();
			oos2.close();
			CourseArray_Data.close();
			student_Data.close();

			System.out.println("All your information has been updated.");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
