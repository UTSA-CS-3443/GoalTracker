package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * User hold a list of goals read from goals.txt
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */

public class User {
	ArrayList<Goal> goals = new ArrayList<Goal>();
	ArrayList<String> lines = new ArrayList<String>();
	public static String compGoals ="";
	
	/*
	 * Empty parameter construction
	 */
	public User() {
	}
	
	/*
	 * Adder
	 */
	public void addGoals(Goal goal) {
		goals.add(goal);
		
	}
	
	/*
	 * Getters
	 */
	public Goal getGoal(int i) {
		return goals.get(i);
	}
	
	public ArrayList<Goal> getAllGoals(){
		return goals;
	}
	
	public String getStringGoals() {
		String output = "";
		
		for(int i = 0; i < goals.size(); i++) {
			output += goals.get(i) + "\n";
		}
		
		return output;
	}
	
	public ArrayList<String> getGoalTitles() {
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i = 0; i < goals.size(); i++) {
			temp.add(goals.get(i).getTitle());
		}
		
		return temp;
	}
	
	
	/*
	 * Removes the selected goal from the array
	 */
	public void deleteGoal(int i) {
		goals.remove(i);
	}
	
	/*
	 * Calls on writer and creates a file in the given location
	 */
	public void goalWriter(String file) {
		try {
		      File goalFile = new File(file);
		      if (goalFile.createNewFile()) {
		        writer(file);
		      } else {
		        writer(file);
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
	}
	public void addCompGoal(String goals) {
		if(compGoals.equals("")) {
			compGoals += getCompGoals("data/completedgoals.txt");
			compGoals+= goals + "\n";
		}
		else {
		compGoals += goals + "\n";
		
		}
		
		}
		
	public String completedGoalsfile(String file) {
		String ret ="";
		if(compGoals.equals("")) {
			compGoals += getCompGoals(file);
		}
		else {
			ret = compGoals;
		}
		return ret;
	}
	public void addFileCompGoals(String file) {
		try {
			 File goalFile = new File(file);
		      if (goalFile.createNewFile()) {
		        compwriter(file);
		      } else {
		        compwriter(file);
		      }
			
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	void compwriter(String file) {
		try {
		FileWriter myWriter = new FileWriter(file);
	      myWriter.write(compGoals);
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public String getCompGoals(String filename) {
		String ret = "";
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()) {
				
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				if(tokens != null && tokens.length == 5) {
					String title = tokens[0];
					String descritption = tokens[1];
					String month = tokens[2];
					String day = tokens[3];
					String year = tokens[4];
					ret += title + "," + descritption + "," + month + "," + day + "," + year + "\n";
					
				}
			
			
			}
			
			
				
			
		}catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	return ret;
	}
	
	/*
	 *Writes out all the goals for the user to a txt that can later be read
	 */
	void writer(String file) {
		try {
		      FileWriter myWriter = new FileWriter(file);
		      myWriter.write(getStringGoals());
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/*
	 * Reads all the goals from a text file
	 */
	public void loadGoals(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println( "Error loading the file - please check its location." );
			e.printStackTrace();
		}
		
		/*
		 * Runs throught the lines read off of the file. Will add data into the scene array
		 */
		int i = 0;
		String data[];
		while(i < lines.size()) {
			Goal temp = new Goal();
			data = ((lines.get(i)).split(",(?!\s)"));
			temp.setTitle(data[0]);
			temp.setGoal(data[1]);
			temp.setDueDate(convertMonth(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
			goals.add(temp);
			i++;
		}
	}
	
	/*
	 * converts the string to an int (month)
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
	 * returns a boolean for the status of the goals list
	 */
	public boolean isGoalsEmpty() {
		boolean output;
		
		if(goals.size() != 0) {
			output = false;
		} else {
			output = true;
	}
	
	return output;
	}
	
	/*
	 * toString
	 */
	public String toString() {
		String output = "";
		
		output += getStringGoals();
		
		return output;
	}

	/**
	 * @return the compGoals
	 */
	
	
	


}
