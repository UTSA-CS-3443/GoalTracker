package application.controller;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * AddGoalsController
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */


public class AddGoalsController implements EventHandler<ActionEvent>, Initializable {

	
	
	
	@FXML
	Label dateLabel, statusLabel;
	
	@FXML
	TextField titleField;
	
	@FXML
	TextArea goalSummary;
	
	@FXML
	DatePicker datePicker;
	
	
	
	/*
	 * Add button gets text from the three fields and updates goal.txt file with the new goal information
	 */
	@FXML
	void addButton(ActionEvent event) {
		statusLabel.setText("");
		String title = titleField.getText();
		String preGoal = goalSummary.getText();
		LocalDate date = datePicker.getValue();
		
		String theGoal = preGoal.replace("\n", " ").replace("\r", " ");
		
		if(title == null || theGoal == null || datePicker.getValue() == null) {
			statusLabel.setText("One or more fields are empty");
			statusLabel.setOpacity(1);
			statusLabel.setTextFill(Color.RED);
			
			} else {
			
			int day = date.getDayOfMonth();
			int month = date.getMonthValue() - 1;
			int year = date.getYear();
			
			User user = new User();
			user.loadGoals("data/goals.txt");
			
			Goal goal = new Goal();
		
		
			
		
			goal.setTitle(title);
			goal.setGoal(theGoal);
			goal.setDueDate(month, day, year);
			statusLabel.setOpacity(0);
		
		
		user.addGoals(goal);
		
		user.goalWriter("data/goals.txt");
		statusLabel.setText("Goal Added");
		titleField.setText("");
		goalSummary.setText("");
		statusLabel.setOpacity(1);
		statusLabel.setTextFill(Color.GREEN);
		datePicker.setValue(null);
		}
	}
	
	/*
	 * backButton loads the MainScreen.fxml
	 */
	@FXML
	void backButton(ActionEvent event) {
		

			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
            
        }
       
	
	
	/*
	 * logout button loads the StartScreen.fxml
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
	
	/*
	 * Creates a Date object and sets the dateLabel to the current date
	 */
	 void timeThread() {
		
		Date date = new Date();
		
		date.todayLabelFormat(dateLabel);
		
	}
	 
	 /*
	  * Initializes the methods listed upon loading the scene
	  */
	 
		public void initialize(URL location, ResourceBundle resources) {
			timeThread();
			
		}


	
	

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}}
