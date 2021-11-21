package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Main displays the app
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */

public class Main extends Application{
	
	
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) {

			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("view/StartScreen.fxml"));						//loads the fxml file
				primaryStage.setScene(new Scene(root, 800, 800));												//sets the scene to "scene"
				primaryStage.setResizable(false);																//Locks the app window size. Not resizeable
				primaryStage.show();																			//shows the stage
				
				stage = primaryStage;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}