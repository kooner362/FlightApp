package application;

/**
 * Throws an exception if a client does not exist.
 * 
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public class NoSuchClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1153874816580793145L;

	/**
	 * Uses the Exception class for no found client.
	 */
	public NoSuchClientException(){
		super();
	}
	
	/**
	 * Is thrown when a client does not exist and a message is wanted to be provided.
	 * 
	 * @param message 
	 * 			the message to be returned
	 */
	public NoSuchClientException(String message){
		super(message);
	}

}
