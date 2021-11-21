package application.model;

/**
 * Quote hold a quote, its author, and a id number
 * 
 * @author Gerardo Flores (hul260)
 * UTSA CS 3443 - GoalTracker
 * Fall 2021
 *
 */


public class Quote {
	
	String quote, author;
	int id;
	
	/*
	 * Constructor for quote
	 */
	public Quote(int id, String quote, String author) {
		this.quote = quote;
		this.id = id;
		this.author = author;
	}
	
	/*
	 * Empty parameter constructor
	 */
	public Quote() {
		quote = "";
		id = 0;
		author = "";
	}
	
	/*
	 * Setters for quote, id, and Author
	 */
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/*
	 * Getters for quote, id, author
	 */
	public String getQuote() {
		return quote;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	/*
	 * toString
	 */
	public String toString() {
		String output = "";
		
		output +=quote + "\n- " + author;
		
		return output;
	}
}
