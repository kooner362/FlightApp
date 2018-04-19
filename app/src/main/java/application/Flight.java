/**
 * 
 */
package application;

import java.io.Serializable;

/**
 * Flight class is used in order to store flight information,
 * it includes flight number, Departure date and time, arrival
 * date and time, the airline, origin, destination, cost and total
 * travel time for flights.
 * <p>
 * This class also implements serializable flight data such as the flight 
 * information in order
 * to pass that information from one layout to another for the 
 * android implementation.
 * 
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public class Flight implements Serializable{
	
	/**
	 * Stores the serializable data version ID for passing data between classes
	 */
	private static final long serialVersionUID = 930099046038887270L;
	/** 
	 * Stores the flightNumber of this Flight.
	 */
	private String flightNumber;
	/** 
	 * Stores the departure time and date of this Flight.
	 */
	private String departureTimeDate;
	/** 
	 * Store the arrival date and time of this Flight.
	 */
	private String arrivalTimeDate;
	/** 
	 * Store the airline name of this Flight.
	 */
	private String airline;
	/** 
	 * Stores the origin of this Flight.
	 */
	private String origin;
	/** 
	 * Stores the destination of this Flight.
	 */
	private String destination;
	/** 
	 * Stores the cost of this Flight..
	 */
	private double cost;
	
	/**
     * Instantiates the current flight by providing the flight number,
     * Departure time/date, arrival time/date, airline name, origin, 
     * destination, and the cost of this Flight.
     * Sets additionally the credit card number, address and expiry date 
     * of the credit card for the current client.
     * 
     * @param flightNumber 
     * 			the flight number of this Flight.
     * @param departureTimeDate 
     * 			the departure time and date in the following format: (YYYY-MM-DD HH:MM)
     * @param arrivalTimeDate 
     * 			the arrival time and date in the following format: (YYYY-MM-DD HH:MM)
     * @param airline 
     * 			the name of the airline company for this Flight.
     * @param origin 
     * 			the origin of this Flight.
     * @param destination 
     * 			the destination of this Flight. 
     * @param cost 
     * 			the cost of this Flight.
     */
	public Flight(String flightNumber, String departureTimeDate, 
			String arrivalTimeDate, String airline, String origin, 
			String destination, String cost){
		
		this.flightNumber = flightNumber;
		this.departureTimeDate = departureTimeDate;
		this.arrivalTimeDate = arrivalTimeDate;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.cost = Double.parseDouble(cost);
	}
	
	/**
	 * Returns the flight number of this Flight.
	 * 
	 * @return the flight number of the given flight
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	
	/**
	 * Sets the flight number of this Flight to flightNumber.
	 * 
	 * @param flightNumber 
	 * 			the flight number of the current flight
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	/**
	 * Returns the departure time/date of this Flight.
	 * 
	 * @return the departureTimeDate
	 */
	public String getDepartureTimeDate() {
		return departureTimeDate;
	}
	
	/**
	 * Sets the departure time date of this Flight to
	 * departureTimeDate which is in the format: (YYYY-MM-DD HH:MM).
	 * 
	 * @param departureTimeDate 
	 * 			the departure date and time to set for this flight
	 */
	public void setDepartureTimeDate(String departureTimeDate) {
		this.departureTimeDate = departureTimeDate;
	}
	
	/**
	 * Returns the arrival time and date of this Flight.
	 * 
	 * @return the arrivalTimeDate
	 */
	public String getArrivalTimeDate() {
		return arrivalTimeDate;
	}
	
	/**
	 * Sets the arrivate time and date of this Flight to
	 * arrivalTimeDate which is in the following format: (YYYY-MM-DD HH:MM).
	 * 
	 * @param arrivalTimeDate 
	 * 			the arrival time and date to set for this flight
	 */
	public void setArrivalTimeDate(String arrivalTimeDate) {
		this.arrivalTimeDate = arrivalTimeDate;
	}
	
	/**
	 * Returns the name of the airline company of this Flight.
	 * 
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}
	
	/**
	 * Sets the name of the airline company for this Flight to airline.
	 * 
	 * @param airline 
	 * 			the airline providing this flight
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	/**
	 * Returns the origin of this Flight.
	 * 
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * Sets the origin of this Flight to origin.
	 * 
	 * @param origin 
	 * 			the origin to set for this flight
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * Returns the destination of this Flight.
	 * 
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * Sets the destination of this Flight to destination.
	 * 
	 * @param destination 
	 * 			the destination to set for this flight
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * Returns the cost of this Flight.
	 * 
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}
	
	/**
	 * Sets the cost of this Flight to cost.
	 * 
	 * @param cost 
	 * 			the cost to set for this flight
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Returns a string representation of the date portion
	 * 
	 * @return the date portion of a datetime, in string
	 */
	public String getDate(){
		int split = this.departureTimeDate.indexOf(" ");
		return this.departureTimeDate.substring(0, split);
	}
	
	/**
	 * Returns true iff other is a flight object and all their
	 * attributes are the same
	 * 
	 * @param other 
	 * 			the object being compared to this Flight, usually another flight.
	 */
	public boolean equals(Object other){
		
		if (!(other instanceof Flight)){
			return false;
		}
		Flight o = (Flight) other;
		return this.toString().equals(o.toString());

	}
	

	@Override
	/**
	 * Returns a string representation of this flight
	 * 
	 * @return the string representation of this Flight.
	 */
	public String toString() {
		return flightNumber + "," + departureTimeDate
				+ "," + arrivalTimeDate + "," + airline + "," + origin
				+ "," + destination + "," + String.format("%.2f", cost);
	} 

}
