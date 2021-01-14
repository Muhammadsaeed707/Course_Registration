package hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read_data {
	private String Courses;
	
	public String read () throws FileNotFoundException { 
		String full = "";
		
		//open file
		File file = new java.io.File("src/MyUniversityCourses.csv");
		Scanner in = null;
		try {
			in = new Scanner(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//read full data into string
		while(in.hasNextLine()) {
			String line = in.nextLine();
			full += line + "/";	
		}
		
		in.close();
		//return string to pass to array method
		return full;
	}
	
	//put data from string to array 
	public static String[][] arrayMaker (String full){
		//add / after each line to split by line
		String[] array = full.split("/");
		
		String [][] array2 = new String[array.length +1][8];

		int count = 0;
		
		//add data to 2 dimensional array
		for (int i = 0; i < array.length; i++) {
			String [] commasplit = array[i].split(",");
			int count2 = 0;
				count ++;
		
			for (int i1 = 0; i1 < commasplit.length; i1 ++) {
				String x = commasplit[i1];
				array2[count][count2] = commasplit[i1];
				count2++;
			}
			
			count2 = 0;
		}
		return array2;
	}
	
	//make arraylist from the 2 dimensional array passed
	public static ArrayList<Course> courseMaker(String [][] array2) {
		ArrayList <Course> CourseList = new ArrayList();
		
		for (int i = 2; i < array2.length; i ++) {
			Course c = new Course();
			//arraylist of course objects
			c.setCourse_Name(array2[i][0]);
			c.setCourse_Id(array2[i][1]);
			c.setMaximum_Students(array2[i][2]);
			c.setInstructor(array2[i][5]);
			c.setCourse_Section(array2[i][6]);
			c.setCourse_Location(array2[i][7]);
			CourseList.add(c);
		}
		return CourseList;
	}
}	
