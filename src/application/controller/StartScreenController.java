package application.controller;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import application.Main;
import application.model.Quotes;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * StartScreenController
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */

public class StartScreenController implements EventHandler<ActionEvent>, Initializable {
	
	@FXML
	Label timeLabel, dailyQuote;
	
	
	
	/*
	 * Start button loads the MainMenu.fxml scene
	 */
	
	public void startButton(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Creates a Calendar instance and takes the values of hour and minutes and applies them to the timeLabel
	 */
	public void timeThread() {

	    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
	        Calendar date = Calendar.getInstance();
	        //String dateInstance = date.get(Calendar.MONTH) + "-" + date.get(Calendar.DATE) + "-" + date.get(Calendar.YEAR);
	        int minute = date.get(Calendar.MINUTE);
	        DecimalFormat mFormat= new DecimalFormat("00");
	        String minuteString = mFormat.format(Double.valueOf(minute));
	        int hour = date.get(Calendar.HOUR);
	        timeLabel.setText(hour + ":" + minuteString);
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	}
	
	/*
	 * dailyQuote reads quotes from "data/quotes.csv"
	 */
	public void dailyQuote() {
		Quotes dailyQuotes = new Quotes();
		dailyQuotes.loadQuotes("data/quotes.csv");
		dailyQuote.setText(dailyQuotes.randomQuote().toString());
	}
	
	/*
	 * Initializes methods upon loading the scene
	 */
	
	public void initialize(URL location, ResourceBundle resources) {
		timeThread();
		dailyQuote();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	


	
}
