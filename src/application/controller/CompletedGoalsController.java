package application.controller;


import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Date;
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

public class CompletedGoalsController implements EventHandler<ActionEvent>, Initializable{
@FXML
private TextArea goals;
@FXML
private Label dateLabel;
@Override
public void initialize(URL location, ResourceBundle resources) {
	Date date = new Date();
	String ret = "";
	date.todayLabelFormat(dateLabel);
	User user = new User();
	ret =user.getCompGoals("data/completedgoals.txt");
	
	String comp = "";
	String compfinal ="";
	String[] tokens = ret.split("\n");
	for(int i = 0; i < tokens.length; i++) {
		comp = tokens[i];
		String[] comps = comp.split(",");
		if(comps.length == 5) {
		String title = comps[0];
		String descritption = comps[1];
		String month = comps[2];
		String day = comps[3];
		String year = comps[4];
		compfinal += "Title: " + title + "\nGoal: " + descritption + "\nDue Date: " + month + " " + day + ", " + year + "\n\n";
		}
	}
	
	
	goals.setText(compfinal);
}
public void back(ActionEvent event) {
	try {
		Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
		Main.stage.setScene(new Scene(root, 800, 800));
		Main.stage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
public void logout(ActionEvent event) {
	try {
		Parent root = FXMLLoader.load(getClass().getResource("../view/StartScreen.fxml"));
		Main.stage.setScene(new Scene(root, 800, 800));
		Main.stage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
@Override
public void handle(ActionEvent event) {
	// TODO Auto-generated method stub
	
}


}
