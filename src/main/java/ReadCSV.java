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
	
	public void dataset() {
	
		String csvFileTreeTrims = "/Users/anirudh/Downloads/Java downloads/DataProcess/docs/311_Service_Requests_-_Tree_Trims.csv";
		String csvFileTreeDebris = "/Users/anirudh/Downloads/Java downloads/DataProcess/docs/311_Service_Requests_-_Tree_Debris.csv";
		BufferedReader br_1= null;
		BufferedReader br_2= null;
		int lineNumber1 = 0;
		int lineNumber2 = 0;
		String cvsSplitBy = ",";
		int counter_1 = 0;
		int counter_2 = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			String data_1,data_2;
			// 1. Fetching data from 311 Service request for tree trims data set and parsing into map
			Map<String, String> maps = new HashMap<String, String>();
			br_1 = new BufferedReader(new FileReader(csvFileTreeTrims));

			// Reading CSV line by line
			   while ((data_1 = br_1.readLine()) != null) {
		       // Parsing CSV to ArrayList 
				CSVtoArrayList(data_1);
				// Counting each entry
			    lineNumber1++;	
			    
				String[] zipcode1 = data_1.split(cvsSplitBy);

				maps.put(zipcode1[3], zipcode1[5]);
		
			    }
			   
			   
                //Getting Zipcode as user input to Display number of requests at that Zipcode  
			   System.out.println("Enter the zipcode to find number of Tree Trim requests: ");
			   String a = scanner.nextLine();
  		       counter_1 = Collections.frequency(maps.values(), a);
			   System.out.println("Tree Trim requests at "  +a + " : " +counter_1);
			   
			   //displaying overall requests for tree trims
			   System.out.println("Total number of Tree Trims requests: " +lineNumber1);
			   
	// 2. Fetching data from 311 Service request for tree debris data set
			br_2 = new BufferedReader(new FileReader(csvFileTreeDebris));
						
			// Reading CSV line by line
			   while ((data_2 = br_2.readLine()) != null) {
				// Parsing CSV to ArrayList
				CSVtoArrayList(data_2);
				//Counting each request
				lineNumber2++;
				String[] zipcode2 = data_2.split(cvsSplitBy);

				maps.put(zipcode2[3], zipcode2[5]);
				}
			   
			   // Getting Zipcodes as user input to display number of requests at that zipcode 
			   System.out.println("Enter the zipcode to find number of Tree Debris requests: ");
			   String b = scanner.nextLine();
  		       counter_2 = Collections.frequency(maps.values(), b);
			   System.out.println("Tree Debris requests at "  +b + " : " +counter_2);
			   
			   //displaying overall requests for tree debris
			   System.out.println("Total number of Tree Debris requests: " +lineNumber2);
			 
			 	
		
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
	// Utility which converts CSV to ArrayList using Split Operation (This is just for testing)
	public ArrayList<String> CSVtoArrayList(String CSV) {
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
		
	public static void main(String[] args) {
		
		ReadCSV readcsv = new ReadCSV();
		readcsv.dataset();
		
	}
}
	
