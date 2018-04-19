package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Itinerary class is used in order to store itinerary information, 
 * it includes flights in an itinerary and instantiates an itinerary.
 * <p>
 * This class also implements serializable flight data such as the 
 * flight information in order to pass that information from one layout
 * to another for the android implementation.
 * 
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public class Itinerary implements Comparable<Itinerary> {
	
	/**
	 * Stores the cost of all flights in the Itinerary.
	 */
	private double cost;
	
	/**
	 * Stores the total durations of all flights in the Itinerary.
	 */
	private double time;
	
	/**
	 * Stores all Flights in an ArrayList.
	 */
	private ArrayList<Flight> flights;
	
	/**
	 * Instantiates an Itinerary of an ArrayList of flights.
	 * 
	 * @param flights
	 * 			an array list of flights
	 */
	public Itinerary(ArrayList<Flight> flights){
		this.flights = flights;
		this.cost = 0;
		for (Flight f : flights){
			this.cost += f.getCost();
		}
		this.time = getDurationInMin();
	}
	
	/**
	 * Returns the cost of all flights in this itinerary.
	 * 
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Sets the total cost of this Itinerary.
	 * 
	 * @param cost 
	 * 			the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Returns the total duration of all flights in this Itinerary.
	 * 
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
	
	/**
	 * Sets the total duration of all flights in this Itinerary.
	 * 
	 * @param time 
	 * 			the time to set
	 */
	public void setTime(double time) {
		this.time = time;
	}
	
	/**
	 * Returns the ArrayList of all flights in this Itinerary.
	 * 
	 * @return the flight
	 */
	public ArrayList<Flight> getFlight() {
		return flights;
	}
	
	/**
	 * Sets the ArrayList of all flights in this Itinerary.
	 * 
	 * @param flight 
	 * 			the flight to set
	 */
	public void setFlight(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	/**
	 * An override of the toString method that returns a string representation
	 * of this itinerary.
	 * Information is displayed by each flight in this Itinerary and duration
	 * and total cost are display after all flights have been represented.
	 * 
	 * The information is delimited by commas.
	 * 
	 * @return string representation of the current itinerary
	 */
	@Override
	public String toString() {
		if (this.flights.size() == 0){
			return "";
		}
		
		String startTime = flights.get(0).getDepartureTimeDate();
		String endTime = flights.get(flights.size() - 1).getArrivalTimeDate();
		String temp = "";
		for (Flight f: flights){
			temp += f.getFlightNumber() + "," + f.getDepartureTimeDate()
			+ "," + f.getArrivalTimeDate() + "," + f.getAirline()
			+ "," + f.getOrigin() + "," + f.getDestination()
			+ "\n";
		}
		temp += String.format("%.2f", this.getCost()) + "\n" 
				+ getDuration(startTime, endTime);
		
		return temp;
	}

	/**
	 * Returns an int less than zero, equivalent to zero, or greater than zero.
	 * Depending on whether thie Itinerary o is greater than, equivalent, 
	 * or less than this Itinerary.
	 * 
	 * @return An int less than zero, equal to zero, or greater than zero
	 * depending, on the comparison.
	 */
	@Override
	public int compareTo(Itinerary o) {
		return Double.compare(this.getCost(), o.getCost());
	}
	
	/**
	 * Returns an int less than zero, greater than zero, or less than zero.
	 * Depending on whether COST is being compared or TIME is being compared.
	 *
	 *@return an int less than zero, greater than zero, or less than zero.
	 */
	public static class Comparators{
		
		// this comparator is used to compare the itineraries by cost
		public static Comparator<Itinerary> COST = new Comparator<Itinerary>(){
			
			public int compare(Itinerary o1, Itinerary o2){
				return Double.compare(o1.getCost(), o2.getCost());
			}
		};
		
		// this comparator is used to compare the itineraries by time
		public static Comparator<Itinerary> TIME = new Comparator<Itinerary>(){
			public int compare(Itinerary o1, Itinerary o2){
				return Double.compare(o1.getTime(), o2.getTime());
			}
		};
	}
	
	/**
	 * Returns the difference in between two dates.
	 * 
	 * @param t1 
	 * 			date with format YYYY-MM-DD HH:MM
	 * @param t2 
	 * 			date with format YYYY-MM-DD HH:MM
	 * @return A String value of the difference between two dates.
	 */
	private String getDuration(String t1, String t2){
		int[] tl1 = convertDateTime(t1);
		int[] tl2 = convertDateTime(t2);
		
		// 0 represents January, and 11 represents december 
		Calendar time1 = new GregorianCalendar(tl1[0], tl1[1] - 1, tl1[2], 
				tl1[3], tl1[4]);
		Calendar time2 = new GregorianCalendar(tl2[0], tl2[1] - 1, tl2[2], 
				tl2[3], tl2[4]);
		return getHourMin(time1, time2);
	}
	
	/**
	 * Returns the difference of two different time values.
	 * 
	 * Converts them into a string in the format of HH:MM.
	 * 
	 * @param time1 
	 * 			first calendar object
	 * @param time2 
	 * 			second calendar object
	 * @return a String representation of the duration in the 
	 * format of hr:min
	 */
	private String getHourMin(Calendar time1, Calendar time2){
		long diff = time2.getTimeInMillis() - time1.getTimeInMillis();
		int hour = ((int)diff/(1000 * 60 * 60));
		int min =  ((int)diff/(1000 * 60)) % 60;
		String h = String.valueOf(hour);
		String m = String.valueOf(min);
		
		// 08:05 instead of 8:5
		if (hour < 10){
			h = "0" + h; 
		}
		if (min < 10){
			m = "0" + m;
		}
		return h + ":" + m;
	}
	
	/**
	 * Returns the total time spent on the trip
	 * 
	 * @return a double, representing the time difference between
	 * 			the departure time of the first flight and the arrival time
	 * 			of the last flight
	 */
	private double getDurationInMin(){
		if (this.flights.size() == 0){
			return 0;
		}
		
		String startTime = flights.get(0).getDepartureTimeDate();
		String endTime = flights.get(flights.size() - 1).getArrivalTimeDate();
		String duration = getDuration(startTime, endTime);
		double totalMin;
		String[] parts = duration.split(":");
		
		// 60 * hour + min
		totalMin = 60 * Double.parseDouble(parts[0]) 
				   + Double.parseDouble(parts[1]);
		return totalMin;
	}
	
	/**
	 * Return an int array that contains the needed data to create
	 * 			a calendar object
	 * 
	 * @param dateTime 
	 * 			a String representation of the date and time
	 * @return an array of int include [year, month, day, hour, min]
	 */
	private int[] convertDateTime(String dateTime){
    	String[] parts = dateTime.trim().split(" ");
    	String date = parts[0];
    	String time = parts[1];
    	parts = date.split("-");
    	int year = Integer.parseInt(parts[0]);
    	int month = Integer.parseInt(parts[1]);
    	int day = Integer.parseInt(parts[2]);
    	parts = time.split(":");
    	int hour = Integer.parseInt(parts[0]);
    	int min = Integer.parseInt(parts[1]);
    	return new int[]{year, month, day, hour, min};
    }
}