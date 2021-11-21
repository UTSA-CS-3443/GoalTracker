package application.model;

import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * Date helps create a date with the needed format. Date, String, Int
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */

public class Date {

	public Date() {
		
	}
	
	/*
	 * Formats the date to (MM DD, YYY) and updates the label
	 */
	public void todayLabelFormat(Label label) {
	 Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
	        Calendar date = Calendar.getInstance();
	        //String dateInstance = date.get(Calendar.MONTH) + "-" + date.get(Calendar.DATE) + "-" + date.get(Calendar.YEAR);
	        int day = date.get(Calendar.DAY_OF_MONTH);
	        int month = date.get(Calendar.MONTH);
	        int year = date.get(Calendar.YEAR);
	        String monthString = "";
			switch(month) {
				case 0: monthString = "Jan";
						break;
				case 1: monthString = "Feb";
						break;
				case 2: monthString = "Mar";
						break;
				case 3: monthString = "Apr";
						break;
				case 4: monthString = "May";
						break;
				case 5: monthString = "Jun";
						break;
				case 6: monthString = "Jul";
						break;
				case 7: monthString = "Aug";
						break;
				case 8: monthString = "Sept";
						break;
				case 9: monthString = "Oct";
						break;
				case 10: monthString = "Nov";
						break;
				case 11: monthString = "Dec";
						break;
				default: monthString = "Invalid Month";
						break;
			}
	        label.setText(monthString + " " + day + ", " + year);
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
}
	
	/*
	 * Formats the date to (MM, YYYY)
	 */
	public String upcomingDateFormat() {
		 Calendar date = Calendar.getInstance();
	        //String dateInstance = date.get(Calendar.MONTH) + "-" + date.get(Calendar.DATE) + "-" + date.get(Calendar.YEAR);
	       // int day = date.get(Calendar.DAY_OF_MONTH);
	        int month = date.get(Calendar.MONTH);
	        int year = date.get(Calendar.YEAR);
	        String monthString = "";
			switch(month) {
				case 0: monthString = "Jan";
						break;
				case 1: monthString = "Feb";
						break;
				case 2: monthString = "Mar";
						break;
				case 3: monthString = "Apr";
						break;
				case 4: monthString = "May";
						break;
				case 5: monthString = "Jun";
						break;
				case 6: monthString = "Jul";
						break;
				case 7: monthString = "Aug";
						break;
				case 8: monthString = "Sept";
						break;
				case 9: monthString = "Oct";
						break;
				case 10: monthString = "Nov";
						break;
				case 11: monthString = "Dec";
						break;
				default: monthString = "Invalid Month";
						break;
			}
			String output = (monthString + ", " + year);
	        return output;
	}
	
	/*
	 * Converts String month to int
	 */
	public int convertMonth(String month) {
       
			int monthInt = 0;
			
			switch(month) {
				case "Jan" : monthInt = 0;
						break;
				case "Feb" : monthInt = 1;
						break;
				case "Mar" : monthInt = 2;
						break;
				case "Apr" : monthInt = 3;
						break;
				case "May" : monthInt = 4;
						break;
				case "Jun" : monthInt = 5;
						break;
				case "Jul" : monthInt = 6;
						break;
				case "Aug" : monthInt = 7;
						break;
				case "Sept" : monthInt = 8;
						break;
				case "Oct" : monthInt = 9;
						break;
				case "Nov" : monthInt = 10;
						break;
				case "Dec" : monthInt = 11;
						break;
		}
		
        return monthInt;
	}
	
	
	/*
	 * Formats the date to (MM DD, YYY) without updating a label
	 */
	public String todayFormat() {
		         
	        Calendar date = Calendar.getInstance();
	        //String dateInstance = date.get(Calendar.MONTH) + "-" + date.get(Calendar.DATE) + "-" + date.get(Calendar.YEAR);
	        int day = date.get(Calendar.DAY_OF_MONTH);
	        int month = date.get(Calendar.MONTH);
	        int year = date.get(Calendar.YEAR);
	        String monthString = "";
			switch(month) {
				case 0: monthString = "Jan";
						break;
				case 1: monthString = "Feb";
						break;
				case 2: monthString = "Mar";
						break;
				case 3: monthString = "Apr";
						break;
				case 4: monthString = "May";
						break;
				case 5: monthString = "Jun";
						break;
				case 6: monthString = "Jul";
						break;
				case 7: monthString = "Aug";
						break;
				case 8: monthString = "Sept";
						break;
				case 9: monthString = "Oct";
						break;
				case 10: monthString = "Nov";
						break;
				case 11: monthString = "Dec";
						break;
				default: monthString = "Invalid Month";
						break;
			}
			String output = (monthString + " " + day + ", " + year);
	        return output;
			    
			    
		}
}
