package application.model;

import java.util.Calendar;

/**
 * Goal will hold a title for the goal, a summary of the goal, and a due date for the goal
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */

public class Goal {
	String goal, title, dueDate;
	Calendar date = Calendar.getInstance();
	int dia, mes, ano;
	
	public Goal() {
		goal = "";
		title = "";
		dueDate = "";
		
	}
	
	/*
	 * Setters for setGoal, setTitle, and setDueDate
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDueDate(int month, int dayOfMonth, int year) {
		date.set(Calendar.MONTH, month);
		date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		date.set(Calendar.YEAR, year);
		
		dia = dayOfMonth;
		mes = month;
		ano = year;
	}
	
	/*
	 * Getters for goal, title
	 * 
	 */
	public String getGoal() {
		return goal;
	}
	
	public String getTitle() {
		return title;
	}
	
	/*
	 * Returns a String formatted date (MONTH,DD,YYYY)
	 */
	public String getDueDateWrite() {
		String output = "";
		
		String monthString = "";
		switch(date.get(Calendar.MONTH)) {
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
		
		output = monthString + "," + date.get(Calendar.DAY_OF_MONTH) + "," + date.get(Calendar.YEAR);
		
		return output;
	}
	
	/*
	 * Returns a String formatted date (MONTH DD,YYYY)
	 */
	public String getDueDate() {
		String output = "";
		
		String monthString = "";
		switch(date.get(Calendar.MONTH)) {
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
		
		output = monthString + " " + date.get(Calendar.DAY_OF_MONTH) + ", " + date.get(Calendar.YEAR);
		
		return output;
	}
	
	/*
	 * a string used to compare just the month and year (MONTH,YYYY)
	 */
	public String getCompare() {
		String output = "";
		
		String monthString = "";
		switch(date.get(Calendar.MONTH)) {
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
		
		output = monthString + " " + ", " + date.get(Calendar.YEAR);
		
		return output;
	}
	
	
	/*
	 * toString and a toStringFormatted that returns a string formatted differently than toString
	 */
	public String toString() {
		String output = "";
		
		output += getTitle() +  "," + getGoal() + "," + getDueDateWrite();
		
		return output;
	}
	
	public String toStringFormatted() {
		String output = "";
		
		output += "Title: " + getTitle() + "\nGoal Summary: " + getGoal() + "\nDue Date: " + getDueDate();
		
		return output;
	}
}
