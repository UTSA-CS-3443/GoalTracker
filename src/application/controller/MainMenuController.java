package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.Date;
import application.model.Goal;
import application.model.User;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class MainMenuController implements EventHandler<ActionEvent>, Initializable
{
	
	
	
	@FXML
	Label  dateLabel;
	
	@FXML
	TextArea todaysGoalsLabel, upcomingGoalsLabel;
	
	public void completedGoals(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/CompletedGoals.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
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
	void loadGoals(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/GoalViewer.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Switches scene to AddGoals.fxml
	 */
	@FXML
	void addGoalButton(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/AddGoals.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Switches scene to StartScreen.fxml
	 */
	@FXML
	void logoutButton(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/StartScreen.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch(Exception e) {
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
	
	public void initialize(URL location, ResourceBundle resources) {
		dateThread();
		todayGoals();
		upcomingGoalsLabel();
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}


	


	
	
	
	
}
