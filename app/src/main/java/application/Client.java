package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * The client class handles searching, sorting, date conversions and client 
 * interactions with the system. It also instantiates the client variables 
 * and extends the User class. Client can be an admin, client
 * or both of the system.
 * <p>
 * This class also implements serializable client data such as
 * the usernames and passwords in order to pass information from
 * one layout to another for the android implementation.
 * 
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public class Client extends User implements Serializable{
    
	/**
	 * Stores the serializable data version ID for passing data between classes
	 */
	private static final long serialVersionUID = -8262915973187590984L;
	
	/** Temporary itinerary list used to store search results.
	 * 
	 */
	private ArrayList<Itinerary> tempItineraryList;
	
	/**
	 * Clients list of saved itineraries once selected. 
	 * Can have none or as many as the client has booked.
	 */
    private ArrayList<Itinerary> bookedItineraries;
    
    /**
     * Clients last name stored as a String variable.
     */
    private String lastName;
    
    /**
     * Clients first name stored as a String.
     */
    private String firstName;
    
    /**
     * Clients email address stored as a string. 
     * There is no format checking in this version of the application.
     */
    private String email;
    
    /**
     * Clients address stored as a String. There is currently no 
     * pre-conditioned formating handled in this version of the application.
     */
    private String address;
    
    /**
     * Client credit card information. Stored as a string.
     */
    private String creditCardNumber;
    
    /**
     * The expiry date of the credit card stored as a String.
     */
    private String expiryDate;
    
    /**
     * Instantiates the current client by providing 
     * the first name last name and email from the super class User.
     * Sets additionally the credit card number, address and expiry date 
     * of the credit card for the current client.
     * 
     * @param lastName 
     * 			the last name of this client
     * @param firstName 
     * 			the first name of this client
     * @param email 
     * 			the email address of this client
     * @param cardNumber 
     * 			the credit card number of this client
     * @param expiryDate
     * 			the expiry date of the credit card for this client
     * @see User for information on common data for 
     * first name, last name and email instantiating
     */
    public Client(String lastName, String firstName, String email,
    		String address, String cardNumber, String expiryDate){
        super(lastName, firstName, email);
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.creditCardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.bookedItineraries = new ArrayList<Itinerary>();
        this.address = address;
    }
    
    /**
     * A blank instance of a single Client.
     */
    public Client(){
    	
    }
    
    /**
     * Returns the address of the current client.
     * 
     * @return the current clients address
     */
    public String getAddress() {
		return address;
	}

    /**
     * Sets the address for the current client.
     * 
     * @param address 
     * 			sets the address provided for the current client
     */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
     * Returns the currently booked itineraries. 
     * 
     * This method can return nothing or 
     * as many itineraries as have been booked.
     * 
     * @return the current confirmed booked itineraries
     */
    public ArrayList<Itinerary> getBookedItineraries() {
		return bookedItineraries;
	}


    /**
     * Sets the confirmed booked itineraries for the current client.
     * This method can be called if the client 
     * wishes to book a selected itinerary, otherwise it is not called.
     * 
     * @param bookedItineraries 
     * 			a list of confirmed booked itineraries, relative to the current client
     */
	public void setBookedItineraries(Itinerary itinerary) {
		this.bookedItineraries.add(itinerary);
	}

	/**
	 * Returns the last name of the current client.
	 * 
	 * @return the last name of the current client
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Sets the last name of the current client.
	 * 
	 * @param lastname 
	 * 			the last name of the current client
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Returns the first name of the current client.
	 * 
	 * @return the first name of the current client
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Sets the first name of the current client.
	 * 
	 * @param firstname 
	 * 			the first name of the current client
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Returns the email address of the current client.
	 * 
	 * @return the email of the current client
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Sets the email address of the current client.
	 * 
	 * @param email 
	 * 			the un-formated email address of the current client.
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Returns the credit card number for the current client.
	 * 
	 * @return creditCardNumber the credit card number for the current client.
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}


	/**
	 * Sets the credit card number for the current client.
	 * 
	 * @param creditCardNumber 
	 * 			the credit card number of the current client.
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	/**
	 * Returns the expiry date for the credit card on 
	 * file for the current client.
	 * 
	 * @return expiry date of the credit card on file for the current client
	 */
	public String getExpiryDate() {
		return expiryDate;
	}


	/**
	 * Sets the expiry date for the credit card on file of the current client.
	 * 
	 * @param expiryDate 
	 * 			the expiry date of the credit card, relative to current client
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * An override of the toString method that returns a 
	 * string representation of this clients last name, first name, 
	 * email address, address, credit card number and 
	 * expiry date of the credit card.
	 * <p>
	 * The information is delimited by commas.
	 * 
	 * @return string representation of the 
	 * current clients complete stored information
	 */
	@Override
	public String toString(){
		return this.lastName + "," + this.firstName + "," 
				+ this.email + "," + this.address + "," 
				+ this.creditCardNumber + "," + this.expiryDate;
	}
	
	/**
	 * Checks if this object is equal to the given object
	 * Return true iff the given object is a client and their
	 * attribute are the same
	 * <p>
	 * Checks each client variable for a match and
	 * returns true or false for each variable.
	 * 
	 * @return true or false dependent on the variable selected
	 */
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Client)){
			return false;
		}
		
		Client other = (Client)o;
		return (this.firstName.equals(other.getFirstName()) 
				&&this.lastName.equals(other.getLastName())
				&&this.email.equals(other.getEmail())
				&&this.address.equals(other.getAddress())
				&&this.creditCardNumber == other.getCreditCardNumber())
				&&this.expiryDate.equals(other.getExpiryDate());
	}

	/**
     * Receives input of a flights origin, destination, 
     * departure date and flight list. If the flight
     * destination and origin match, will not create a flight. 
     * If the origin and destination are different 
     * and the departure date from the origin exists in the list of 
     * available flights, this method will 
     * return a list of possible itineraries temporarily.
     * <p>
     * If the client chooses one of the itineraries in the 
     * temporary itinerary list, it will be added to the 
     * clients currently booked itineraries. 
     * 
     * @param origin 
     * 			starting city of the flight
     * @param departureTime 
     * 			the date wanted for the departure
     * @param destination 
     * 			the end destination wanted
     * @param flightMap 
     * 			a list of all possible flights
     * @return a temporary array list of itineraries that match 
     * 			the current search criteria provided
     */
    public ArrayList<Itinerary> searchItinerary(String origin, 
    		String departureDate, String destination, 
    		HashMap<String, ArrayList<Flight>> flightMap){
        this.tempItineraryList = new ArrayList<Itinerary>();
        
        // if the origin is the same as the destination, no flights needed
        if (origin.equals(destination)){
        	return this.tempItineraryList;
        }
        
        // check if there are flights on the provided departure date from 
        if (flightMap.containsKey(origin)){
	        for (Flight flight: flightMap.get(origin)){
	        	if (onSameDate(departureDate, flight.getDepartureTimeDate())){
	        		HashSet<String> visited = new HashSet<String>();
	        		visited.add(origin);
	        		ArrayList<Flight> currentPath = new ArrayList<Flight>();
	        		currentPath.add(flight);
	                findItineraries(flight.getDestination(), destination, 
	                		visited, flight.getArrivalTimeDate(), 
	                		currentPath, flightMap);
	        	}
	        }
        }
        return this.tempItineraryList;
    }
    
    /**
     * Returns the list of flights available given the date, origin,
     * destination from all possible flights.
     * <p>
     * This method can return a total of flights that matches 
     * all available flights. If no flights are found throws 
     * NoSuchFlightException.
     * 
     * @param date 
     * 			the day of departure of the current flight
     * @param origin 
     * 			the city of departure of the current flight
     * @param destination 
     * 			the city of arrival of the current flight
     * @param flights 
     * 			ArrayList of flights with origin origin.
     * @return trimmed string representation of the current flight
     * @throws NoSuchFlightException if no flight is found.
     */
    
    public String getFlights(String date, String origin, 
    		String destination, ArrayList<Flight> flights) 
    				throws NoSuchFlightException{
    	
    	// A temporary empty string to be or not to be filled by 
    	// flights meeting the conditions
    	String temp = "";
    	
    	for (Flight flight: flights){
    		if ((flight.getDestination().equals(destination)) 
    				&& (flight.getDate().equals(date))){
    			temp += flight.toString() + "\n";
    		}
    	}
    	if (temp != ""){
    		return temp.trim();
    	}
    	else{throw new NoSuchFlightException();}
    	
    }
    
    /**
     * Returns a list of itineraries sorted by cost. 
     * 
     * @return temporary itinerary list sorted by cost
     */
    public ArrayList<Itinerary> searchItinerariesCost(){
        Collections.sort(this.tempItineraryList, 
        		Itinerary.Comparators.COST);
        return this.tempItineraryList;
    }
    
    /**
     * Returns a list of itineraries sorted by duration.
     * 
     * @return temporary itinerary list sorted by duration
     */
    public ArrayList<Itinerary> searchItinerariesTime(){
    	Collections.sort(this.tempItineraryList,
    			Itinerary.Comparators.TIME);   
    	return this.tempItineraryList;
    }
    
    /**
     * Returns a string representation of the clients search results.
     * 
     * @return a list of itineraries based on the clients search
     */
    public String displaySearch(){
        return displayItineraries(this.tempItineraryList);
    }
    
    /**
     * Books a selected flight to be added the current clients itinerary list. 
     * <p>
     * This method is invoked if the client chooses a returned 
     * available flight based on their 
     * search criteria to be added to a list of their itineraries.
     * 
     * @param itinerary
     * 			a selected itinerary to be added to a users booked itineraries
     */
    public void bookItinerary(Itinerary itinerary){
        this.bookedItineraries.add(itinerary);
    }
    
    /**
     * Returns all the confirmed booked itineraries for the current client.
     * 
     * @return all confirmed and booked itineraries for the current client.
     */
    public String viewBooked(){
        return displayItineraries(this.bookedItineraries);
    }
    
    /**
     * A method to be used in future versions of the application
     * in order for the current client to change their stored information.
     * <p>
     * This description was added as of version 1.0.
     */
    public void editInformation(){
    	//This method is a blank method created in version 1.0 
    	//and will be implemented in future application versions.
    }
    
    /**
     * An unimplemented method that allows the current client
     * to edit their billing information.
     * <p>
     * This description was added as of version 1.0.
     */
    public void editBilling(){
    	//This method is a blank method created in version 1.0 and 
    	//will be implemented in future application versions.
    }
            
    /**
     * Helper method generated to assist in locating all possible 
     * itineraries based on an origin, destination, if the client 
     * has visited this destination previously, the date 
     * the current client visited, the list of current flights and a list
     * of all available flight connections.
     * 
     * 
     * @param origin 
     * 			starting city of the itinerary
     * @param destination 
     * 			ending city of the itinerary
     * @param visited 
     * 			if destination has been visited in the past
     * @param time 
     * 			the date when the itinerary was created
     * @param currentPath 
     * 			path to the file that stores flight information
     * @param flightMap 
     * 			all possible flights from the origin to the destination
     */
    private void findItineraries(String origin, String destination, 
    		HashSet<String> visited, String time, 
    		ArrayList<Flight> currentPath, 
    		HashMap<String, ArrayList<Flight>> flightMap){
    	
    	//Checks if the origin is the same as the destination
        if (origin.equals(destination)){
            Itinerary itin = new Itinerary(currentPath);
            this.tempItineraryList.add(itin);
        }else{
            //flightMap is the flights matching origin in the list of flights
        	if (flightMap.containsKey(origin)){
		        for (Flight nextFlight: flightMap.get(origin)){
		        	if (nextFlightValid(nextFlight, time, visited)){ 
			        	HashSet<String> newVisited = 
			        			new HashSet<String>(visited);
			        	ArrayList<Flight> newPath = 
			        			new ArrayList<Flight>(currentPath);
		        		newVisited.add(nextFlight.getDestination());
		        		newPath.add(nextFlight);
		        		findItineraries(nextFlight.getDestination(), 
		        				destination, newVisited, 
		        				nextFlight.getArrivalTimeDate(), 
		        				newPath, flightMap);
		            }
		        }
        	}
        }
    }
    
    /**
     * Helper method that checks if the next destination is 
     * a valid flight option based on the 
     * criteria given. The connecting flight option must meet 
     * specified guidelines of a lay over no longer than six hours.
     * <p>
     * This method can return true or false dependent on the 
     * information provided or not be invoked if 
     * there are no connecting flights needed.
     * 
     * @param flight 
     * 			the current trip
     * @param time 
     * 			the day needed for the departure
     * @param visited 
     * 			if the current destination has been reached
     * @return true or false if there is a connecting flight available 
     */
    private boolean nextFlightValid(Flight flight, String time, 
    		Set<String> visited){
        
    	if (visited.contains(flight.getDestination())){
            return false;
        }
        
    	//current time must be earlier than the departuretime
    	//of the next flight
        if (!isEarlier(time, flight.getDepartureTimeDate())){
        	return false;
        }
        
        //checks if the wait time is within 6 hours
        if (!withinWaitTime(time, flight.getDepartureTimeDate())){
            return false;
        }   
        return true;             
    }
    
    /**
     * Helper method that converts the string representation of 
     * the date and time provided into a usable 
     * integer for making duration calculations and checking if 
     * flights meet requirements.
     * <p>
     * This method is needed to calculate the duration of the flight 
     * for connecting flights as well as regular single flight durations. 
     * This method does not assist in applying flight rules such as 
     * origin date and time cannot be after departure date and time 
     * or make calculation on if a flight is 
     * valid based on time requirements for connection flights.
     * 
     * @param dateTime 
     * 			provided string representation to be converted 
     * @return a usable integer representation of the duration of the flight
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
	
	/**
	 * Helper method that converts a given string date format and 
	 * return an integer array of the different parts of the date information.
	 * <p>
	 * This method selectively returns only the year, month and day 
	 * from the provided date string representation as an integer array.
	 * 
	 * @param date 
	 * 			the given string of day, month, year, hour, minutes
	 * @return integer array of only the year, month and day
	 */
	private int[] convertDate(String date){
		String[] parts = date.trim().split("-");
    	int year = Integer.parseInt(parts[0]);
    	int month = Integer.parseInt(parts[1]);
    	int day = Integer.parseInt(parts[2]);
    	return new int[]{year, month, day};
	}
	
	/**
	 * Helper method that converts the provided string representation of the 
	 * flight date and time to a usable gregorian calendar format.
	 * 
	 * @param dateTime 
	 * 			the string of day, month, year, hour, minutes.
	 * @return Calendar time list array
	 */
	private Calendar toDateTime(String dateTime){
		int[] timeList = convertDateTime(dateTime);
		
		// 0 represents January, and 11 represents December
		return new GregorianCalendar(timeList[0], timeList[1] - 1, 
	    	timeList[2], timeList[3], timeList[4]);
	}
	
	/**
	 * Helper method used to convert provided string representation of 
	 * the date to usable calendar time list.
	 * 
	 * @param date 
	 * 			a string representation of day, month, year, hour, minutes
	 * @return Calendar time list arrays
	 */
	private Calendar toDate(String date){
		int[] timeList = convertDate(date);
		
		// 0 represents January, and 11 represents december
		return new GregorianCalendar(timeList[0], timeList[1] - 1, 
		    	timeList[2], 0, 0);
		
	}
                        
	/**
	 * Helper method used to check if one date time is prior to another.
	 * <p>
	 * Used in conjunction with methods that calculate duration based on 
	 * inputed date time into those functions.
	 * 
	 * @param t1 
	 * 			First duration provided string representation 
	 * @param t2 
	 * 			Second duration provided string representation
	 * @return true if the first time is less than or equal 
	 * to the second time or false if not.
	 */
    private boolean isEarlier(String t1, String t2){
    	Calendar time1 = toDateTime(t1);
    	Calendar time2 = toDateTime(t2);
    	
        return time1.getTimeInMillis() <= time2.getTimeInMillis();
    }

    /**
     * Helper method used in order to check if the connecting flight is 
     * within six hours of the arrival time of the 
     * previous flight.
     * 
     * @param t1 
     * 			first date/time to check
     * @param t2 
     * 			second date/time to check
     * @return true if the second time minus the first time in 
     * 			within the 6 hour connecting flight rule.
     */
    private boolean withinWaitTime(String t1, String t2){
   
    	Calendar time1 = toDateTime(t1);
    	Calendar time2 = toDateTime(t2);
    	
    	//if the time difference is less than 6 hrs
    	return (time2.getTimeInMillis() - time1.getTimeInMillis())
    			<= 6 * 60 * 60 * 1000;
    }
    
    /**
     * If two time periods fall within the same date, 
     * this helper method will check if the second time
     * minus the first time is less that 24 hours and return true if so.
     * <p>
     * Method is only used for flights with the same date.
     * 
     * @param date 
     * 			first date provided
     * @param dateTime 
     * 			the date and time of date provided
     * @return true if the date and time given fall on the same date
     */
    private boolean onSameDate(String date, String dateTime){
    	
    	//departureDate does not have hour and second
    	Calendar time1 = toDate(date);
    	Calendar time2 = toDateTime(dateTime);
    	
    	//if time2 - time1 is less than 24 hrs, time2 has to be on the
    	//same day as time1 since time1 is set to be 00:00 on a certain day
    	return (time2.getTimeInMillis() - time1.getTimeInMillis())
    			< 24 * 60 * 60 * 1000
    			&& (time2.getTimeInMillis() - time1.getTimeInMillis()) >= 0;
    }

    /**
     * Provides a string representation of the itineraries 
     * in the current clients itinerary list.
     * <p>
     * Returns an empty string if there are no itineraries 
     * for the current client.
     * 
     * @param itineraryList 
     * 			a list of itineraries 
     * @return trimmed string representations of the itineraries in 
     * 			the provided itinerary list
     */
    private String displayItineraries(ArrayList<Itinerary> itineraryList){
    	String temp = "";
        for (Itinerary itin: itineraryList){
            temp += itin.toString() + "\n";
        }
        
        //remove the last new line
        return temp.trim();
    }   
}