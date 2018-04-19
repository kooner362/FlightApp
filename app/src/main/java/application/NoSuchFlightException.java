package application;

/**
 * Throws an exception if a flight does not exist.
 * 
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public class NoSuchFlightException extends Exception {

	/**
	 * Variable used for data serialization.
	 */
	private static final long serialVersionUID = 5274042623202401361L;
	
	/**
	 * Uses the Exception class for no found flight.
	 */
	public NoSuchFlightException(){
		super();
	}
	
	/**
	 * Is thrown when a flight does not exist and a message is wanted to be provided.
	 * 
	 * @param message 
	 * 			the message to override the parent method and be returned
	 */
	public NoSuchFlightException(String message){
		super(message);
	}

}
