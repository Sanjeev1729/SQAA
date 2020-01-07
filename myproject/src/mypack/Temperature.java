package mypack;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

class validator {
	 
	boolean validateDate(String date) {
		
		return true;		
	}
	
	public int compareDate(String date1 , String date2) {
		Date d1 = new Date(date1);
		Date d2 = new Date(date2);
		if(d1.compareTo(d2)==1) {
			return 1;
		}
		if(d1.compareTo(d2)==-1) {
			return -1;
		}
		return 0;
	}
	
	public static void sortDate(String date[]) {
		
	}
}

class AverageTemp {
	
	public void dateRangeAndAverage(String start, String end) throws FileNotFoundException {
	  File file = new File("D:\\myFile.txt"); 
	  Scanner data = new Scanner(file); 
	  System.out.println(data);
	  
	  String prevFromDate = "" , prevEndDate = "";
	  int avgMax = 0;
	  boolean isFirstTime = true;
	  LinkedHashMap lhm = new LinkedHashMap<String,String>();
	  while (data.hasNextLine()) {      //assuming that the data available is in ascending order for the dates if not sort
	    	String str = data.nextLine();
	    	String splitString[]  = str.split(" ");
			String fromDate = splitString[0];
			String toDate = splitString[1];
			int temp = Integer.parseInt(splitString[2]);
			int id =  Integer.parseInt(splitString[3]); 
			validator val = new validator();		
		/*	if(val.compareDate(start,fromDate)>-1) {
				if(val.compareDate(toDate, end)<=0) {
					if(avgMax<temp) {
						avgMax = temp;
						prevsDate = fromDate;
						System.out.println("Start Date"+prevsDate+"to"+"End Date"+toDate+" "+avgMax);
					}else {
						
					}
					continue;
				}else {
					if(val.compareDate(date1, date2)) {
						
					}
				}
			} */
			if(isFirstTime) {
				lhm.put(fromDate, toDate);
				prevEndDate = toDate;
				prevFromDate = fromDate;
			}else {
				if(val.compareDate(prevFromDate,fromDate)>=0 && val.compareDate(prevEndDate,toDate)>=0) {
					prevEndDate = toDate;
					continue;
				}
				else if(val.compareDate(prevFromDate,fromDate)>=0 && val.compareDate(prevEndDate,toDate)<0) {
					lhm.put(prevFromDate, toDate);
				}
				else if(val.compareDate(prevEndDate,fromDate)<0) {
					lhm.put(fromDate,toDate);
				}
			}
	   }
	  Iterator itr = Iterator<T>(lhm);
}
public class Temperature {
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	    String startDate = "" , endDate = "";
	    System.out.println("Enter the start date");
	    startDate = sc.nextLine();
	    endDate = sc.nextLine();
	    validator v = new validator();
	    boolean d1 = v.validateDate(startDate); //assuming that date entered is there in data list
	    boolean d2 = v.validateDate(endDate);
	    if(d1 && d2) {
	    AverageTemp at = new AverageTemp();
	    try {
	     at.dateRangeAndAverage(startDate,endDate);
	    }catch(Exception e) {
	    	
	    }
	   }else {
		   System.out.println("Date Range is not valid od or data not available for selected date range");
	   }
	}
}
