package application.controller;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;

import application.Main;
import application.model.Quotes;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class StartScreenController {
	
	@FXML
	Label timeLabel, dailyQuote;
	
	@FXML
	Button startButton;
	
	/*
	 * Start button loads the MainMenu.fxml scene
	 */
	@FXML
	public void startButton() {
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
	@FXML
	public void initialize() {
		timeThread();
		dailyQuote();
	}


	
}
