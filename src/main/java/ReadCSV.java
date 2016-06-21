package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
 

 
public class ReadCSV {
	public static void main(String[] args) {
		
		String csvFileTreeTrims = "/Users/me/Desktop/HW1/src/main/resources/311_Service_Requests_-_Tree_Trims.csv";
		String csvFileTreeDebris = "/Users/me/Desktop/HW1/src/main/resources/311_Service_Requests_-_Tree_Debris.csv";
		BufferedReader br_1= null;
		BufferedReader br_2= null;
		int lineNumber1 = 0;
		int lineNumber2 = 0;
		String cvsSplitBy = ",";
		int counter = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			String data_1,data_2;
			// 1. Fetching data from 311 Service request for tree trims data set
			Map<String, String> maps = new HashMap<String, String>();
			br_1 = new BufferedReader(new FileReader(csvFileTreeTrims));

			// Reading CSV line by line
			   while ((data_1 = br_1.readLine()) != null) {
		       
				   CSVtoArrayList(data_1);
			       lineNumber1++;	
			       String[] zipcode_1 = data_1.split(cvsSplitBy);
                   maps.put(zipcode_1[3], zipcode_1[5]);
		
			    }
			   
			   
		   System.out.println("Enter the zipcode to find number of Tree Trim requests: ");
			   String a = scanner.nextLine();
  		       counter = Collections.frequency(maps.values(), a);
			   
			   System.out.println("Total Tree Trim requests at "  +a + " : " +counter);
			   
			   
	// 2. Fetching data from 311 Service request for tree debris data set
			br_2 = new BufferedReader(new FileReader(csvFileTreeDebris));
						
			// Reading CSV line by line
			   while ((data_2 = br_2.readLine()) != null) {
				   String[] zipcode_2 = data_2.split(cvsSplitBy);

					maps.put(zipcode_2[3], zipcode_2[5]);
				CSVtoArrayList(data_2);
				lineNumber2++;
				
				}
			   System.out.println("Enter the zipcode to find number of Tree Debris requests: ");
			   String b = scanner.nextLine();
  		       counter = Collections.frequency(maps.values(), b);
			   
			   System.out.println("Total Tree Trim requests at "  +b + " : " +counter);
			   
			   System.out.println("Total number of Tree Debris requests made to 311: " +lineNumber2);
			   System.out.println("Total number of Tree Trims requets made to 311: " +lineNumber1); 
			 	
		
			   } catch (IOException e) {
			e.printStackTrace();
		}
		
		  
		finally {
			try {
				if (br_1 != null) 
					br_1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> CSVtoArrayList(String CSV) {
		ArrayList<String> Result = new ArrayList<String>();
		
		if (CSV != null) {
			String[] splitData = CSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					Result.add(splitData[i].trim());
				}
			}
		}
		
		return Result;
	}
		
}
	
