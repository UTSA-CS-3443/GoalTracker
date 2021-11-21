package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Quotes will hold quotes in a ArrayList and will have a reader to load the quotes to the array
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */


public class Quotes {
	ArrayList<Quote> quotes = new ArrayList<Quote>();
	ArrayList<String> lines = new ArrayList<String>();
	
	/*
	 * Constructor empty parameter
	 */
	public Quotes() {
		
	}
	
	/*
	 * Adder
	 */
	public void addQuote(Quote quote) {
		quotes.add(quote);
	}
	
	/*
	 * Getter
	 */
	public Quote getQuote(int i) {
		return quotes.get(i);
	}
	
	/*
	 * Returns a random quote
	 */
	public Quote randomQuote() {
		Random rand = new Random();
		int upperbound = quotes.size() - 1;
		
		int intRandom = rand.nextInt(upperbound);
		
		return getQuote(intRandom);
	}
	
	/*
	 * Will load quotes from a provided .csv file
	 */
	public void loadQuotes(String file) {
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
		 * Runs through the lines read off of the file. Will add data into the scene array
		 */
		int i = 0;
		String data[];
		while(i < lines.size()) {
			Quote temp = new Quote();
			data = ((lines.get(i)).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
			temp.setId(Integer.parseInt(data[0]));
			temp.setQuote(data[1]);
			temp.setAuthor(data[2]);
			
			quotes.add(temp);
			i++;
		}
	}
	
	/*
	 * toString
	 */
	public String toString() {
		String output = "";
		
		for(int i = 0; i < quotes.size(); i++) {
			output += quotes.get(i) + "\n\n";
		}
		
		return output;
	}
}
