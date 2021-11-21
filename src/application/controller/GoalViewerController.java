package application.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import application.Main;
import application.model.Date;
import application.model.Goal;
import application.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * GoalViewerController
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */

public class GoalViewerController {

	@FXML
	Button backButton, logoutButton, resetButton, editButton, deleteButton, findButton;
	
	@FXML
	Label dateLabel, statusLabel;
	
	@FXML
	TextArea goalSummaryArea;
	
	@FXML
	ChoiceBox<String> goalsChoice;
	
	@FXML
	DatePicker dueDatePicker;
	
	@FXML
	TextField goalTitleField;
	
	
	/*
	 * deleteButton grabs the goal that is in the choiceBox and deletes it. Updates the goals.txt file
	 */
	@FXML
	void deleteButton(Event event) {
		User user = new User();
		user.loadGoals("data/goals.txt");
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals = user.getAllGoals();
		
		
		if(goalsChoice.getValue() == null) {
			statusLabel.setOpacity(1);
			statusLabel.setText("Choose a goal or add one");
		} else {
		
		
		String choice = goalsChoice.getValue().toString();
		
		for(int i = 0; i < goals.size(); i++) {
			if(choice.equals(goals.get(i).getTitle())) {
				user.deleteGoal(i);
			}//if
		}//for
		
		user.goalWriter("data/goals.txt");
		resetButton();
		statusLabel.setText("Goal Removed");
		setChoiceBox();
		}
	}
	
	/*
	 * Sets the items in the choice box by reading the goal titles and applying the Strings to the choicebox
	 */
	@FXML
	void setChoiceBox() {
		User user = new User();
		user.loadGoals("data/goals.txt");
		ArrayList<String> titles = new ArrayList<String>();
		titles = user.getGoalTitles();
		
		ObservableList<String> goalTitles = FXCollections.observableArrayList();
		
		for(int i = 0; i < titles.size(); i++) {
			goalTitles.addAll(titles.get(i));
		}
		
		goalsChoice.setItems(goalTitles);
	}
	
	/*
	 * findButton reads the selected goal off of goals.txt. Displays the goal info in the text labels/areas
	 */
	@FXML
	void findButton() {
		User user = new User();
		user.loadGoals("data/goals.txt");
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals = user.getAllGoals();
		Goal temp = new Goal();
		
		String choice = "";
		
		if(goalsChoice.getValue() == null) {
			statusLabel.setOpacity(1);
			statusLabel.setText("Choose a goal or add one");
		} else {
			choice = goalsChoice.getValue().toString();
		}
		
		for(int i = 0; i < goals.size(); i++) {
			if(choice.equals(goals.get(i).getTitle())) {
				temp = goals.get(i);
			}//if
		}//for
		
		goalTitleField.setText(temp.getTitle());
		goalSummaryArea.setText(temp.getGoal());
		dueDatePicker.setPromptText(temp.getDueDate());
	}
	
	/*
	 * Edit button will get the text from the label, textArea, and datePicker and update the goals.txt file with the new info
	 */
	@FXML
	void editButton() {
		User user = new User();
		user.loadGoals("data/goals.txt");
		ArrayList<Goal> goals = new ArrayList<Goal>();
		goals = user.getAllGoals();
		Goal goalTitle = new Goal();
		
		if(goalsChoice.getValue() == null) {
			statusLabel.setText("No goal selected");
			statusLabel.setOpacity(1);
		} else {
			goalTitle.setTitle(goalsChoice.getValue());
			
			String choice = goalsChoice.getValue().toString();
			
			for(int i = 0; i < goals.size(); i++) {
				if(choice.equals(goals.get(i).getTitle())) {
					goals.get(i).setTitle(goalTitleField.getText());
					String goalSummaryFormat = goalSummaryArea.getText().replace("\n", " ").replace("\r", " ");
					goals.get(i).setGoal(goalSummaryFormat);
					
					if(dueDatePicker.getValue() == null) {
						statusLabel.setOpacity(1);
					}else {
						LocalDate date = dueDatePicker.getValue();
					
						int day = date.getDayOfMonth();
						int month = date.getMonthValue() - 1;
						int year = date.getYear();
					
						goals.get(i).setDueDate(month, day, year);
					}
				}
				
			user.goalWriter("data/goals.txt");
			resetButton();
			statusLabel.setText("Goal Updated!");
			statusLabel.setOpacity(1);
			}//if
		}//for
		
	}
	
	/*
	 * reset button deletes the text from the labels and textArea
	 */
	@FXML
	void resetButton() {
		goalTitleField.setText("");
		goalSummaryArea.setText("");
	}
	
	/*
	 * Back button loads MainMenu.fxml
	 */
	@FXML
	void backButton(Event event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MainMenu.fxml"));
			Parent root = (Parent)fxmlLoader.load();
            Main.stage.setScene(new Scene(root, 800, 800));
            Main.stage.show();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/*
	 * logoutButton loads StartScreen.fxml
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
	@FXML
	public void initialize() {
		timeThread();
		setChoiceBox();
	}
}
