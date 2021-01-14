package hw1;

import java.util.ArrayList;
import java.io.Serializable;

public class User implements Serializable {
	//create variables
	private String username;
	private String password;
	private String FirstName;
	private String LastName;
	
	//arg and no arg constructor 
	public User (String username, String password, String fname, String lname) {
		this.username = username;
		this.password = password;
		this.FirstName = fname;
		this.LastName = lname;
	}
	
	public User () {
		
	}
	
	public void viewAllCourses(ArrayList<Course> courses) {
		
	}
	
	//getters and setters
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}
	
	public void setLastName(String lastName) {
		LastName = lastName;
	}
}
