package application;

import java.util.ArrayList;

import application.model.Date;
import application.model.Goal;
import application.model.User;

public class testDriver {
	
	public static void main(String[] args){
	
		User user = new User();
		user.loadGoals("data/goals.txt");
		
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals = user.getAllGoals();
		
		Date date = new Date();
		String today = date.todayFormat();
		
		String todayGoalsString = "";
		
		if(goals.size() == 0) {
			System.out.println("goals is empty");
		} else {
			for(int i = 0; i < goals.size(); i++) {
				System.out.println("goal: " + goals.get(i) + "\nToday: " + today);
				if(today.equals(goals.get(i).getDueDate())){
					todayGoalsString += goals.get(i) + "\n";
				}//if(comparing goal due date and today)
			}//for
		}//if
			System.out.println(todayGoalsString);
	
	}
}
