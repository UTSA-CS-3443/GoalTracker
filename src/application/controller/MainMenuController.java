package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.Date;
import application.model.Goal;
import application.model.User;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * MainMenuController
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */

public class MainMenuController implements EventHandler<Event>{
	
	@FXML
	Button logoutButton, allGoalsButton, addGoalButton;
	
	@FXML
	Label  dateLabel;
	
	@FXML
	TextArea todaysGoalsLabel, upcomingGoalsLabel;
	
	
	/*
	 * Creates a user and sets label text from the information read off of "data/goals.txt"
	 */
	void todayGoals() {
		User user = new User();
		user.loadGoals("data/goals.txt");
		
		ArrayList<Goal> goals = new ArrayList<Goal>();
		ArrayList<Goal> todayGoals = new ArrayList<Goal>();
		goals = user.getAllGoals();
		
		Date date = new Date();
		String today = date.todayFormat();
		String labelOutput = "";
		
		
		if(goals.size() == 0) {
			//todaysGoalsLabel.setAlignment(Pos.CENTER);
			todaysGoalsLabel.setText("No goals due today");
		} else {
			for(int i = 0; i < goals.size(); i++) {
				if(today.equals(goals.get(i).getDueDate())){
					todayGoals.add(goals.get(i));
				}//if(comparing goal due date and today)
			}//for
		}//if
			//todaysGoalsLabel.setAlignment(Pos.TOP_LEFT);
			for(int i = 0; i < todayGoals.size(); i++) {
				labelOutput += "Title: " + todayGoals.get(i).getTitle() + "\nGoal: " + todayGoals.get(i).getGoal() + "\nDue Date: " + "TODAY\n\n";
			}
			
			todaysGoalsLabel.setText(labelOutput);
	}
	
	
	/*
	 * Creates using the date from "data/goals.txt". Reads all goals and sets the goal strings to the upcomingGoalsLabel
	 */
	void upcomingGoalsLabel() {
		User user = new User();
		user.loadGoals("data/goals.txt");
		
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals = user.getAllGoals();
		
		String labelOutput = "";
		
		
		if(goals.size() == 0) {
			
		} else {
			for(int i = 0; i < goals.size(); i++) {
					labelOutput += goals.get(i).toStringFormatted() + "\n\n";
			}//for
		}//if
			
			
			upcomingGoalsLabel.setText(labelOutput);
	}
	
	
	/*
	 * Switches scenes to GoalViewer.fxml
	 */
	@FXML
	void loadGoals(Event event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/GoalViewer.fxml"));
			Parent root = (Parent)fxmlLoader.load();
            Main.stage.setScene(new Scene(root, 800, 800));
            Main.stage.show();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/*
	 * Switches scene to AddGoals.fxml
	 */
	@FXML
	void addGoalButton(Event event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddGoals.fxml"));
			Parent root = (Parent)fxmlLoader.load();
            Main.stage.setScene(new Scene(root, 800, 800));
            Main.stage.show();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/*
	 * Switches scene to StartScreen.fxml
	 */
	@FXML
	void logoutButton(Event event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/StartScreen.fxml"));
			Parent root = (Parent)fxmlLoader.load();
            Main.stage.setScene(new Scene(root, 800, 800));
            Main.stage.show();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	void dateThread() {
		
		Date date = new Date();
		
		date.todayLabelFormat(dateLabel);
		
	}
	
	/*
	 * Initializes some of the labels upon loading scene
	 */
	@FXML
	void initialize() {
		dateThread();
		todayGoals();
		upcomingGoalsLabel();
	}
	
	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
