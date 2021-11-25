package application.model;

public class completedGoals {
	private String title;
	private String goal;
	private String month;
	private String day;
	private String year;
	public completedGoals(String title, String goal, String month,String day, String year) {
		this.title = title;
		this.goal = goal;
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "completedGoals [title=" + title + ", goal=" + goal + ", month=" + month + ", day=" + day + ", year="
				+ year + "]";
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the goal
	 */
	public String getGoal() {
		return goal;
	}
	/**
	 * @param goal the goal to set
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}




}
