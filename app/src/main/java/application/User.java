package application;

import java.util.ArrayList;

/**
 * The User class is extended by client and in version 2.0 admin. It instantiates a users 
 * common variables such as their first name, last name and email address.
 * <p>
 * Future implementation of admin class and other user types are made possible because of 
 * the abstract user class. More commonalities can also be added and instantiated here in order 
 * to limit repetition and ease creation of members of the application.
 * 
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public abstract class User{
	
	/**
	 * Stores the first name of the current user.
	 */
    private String firstName;
    
    /**
     * Stores the last name of the current user.
     */
    private String lastName;
    
    /**
     * Stores the email address of the current user.
     */
    private String email;
    
    /**
     * Instantiates the user with a first name, last name and email address.
     * <p>
     * Constructor for the user.
     * 
     * @param lastName
     * 			last name of the current user
     * @param firstName
     * 			first name of the current user
     * @param email
     * 			full email address of the current user
     */
    public User(String lastName, String firstName, String email){
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }
    
    /**
     * Empty user class used for serializing data.
     * <p>
     * To be further implemented in version 2.0 when need arises.
     */
    public User(){
    	
    }
    
    /**
     * This method is hardly called. It is used in the case of wanting to clear the Itinerary Search.
     * 
     * @return Clears the search by returning null.
     */
    public ArrayList<Itinerary> searchItineraries(){
		return null;
		
    }
    
    /**
     * Empty method used for data serialization. 
     * <p>
     * Will be further implemented in version 2.0 when the need arises.
     */
    public void displayItineraries(){
        
    }

	/**
	 * Retrieves the first name of the current user.
	 * 
	 * @return the first name of the user
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the current user.
	 * 
	 * @param firstName 
	 * 			first name for the current user
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the current user.
	 * 
	 * @return the last name of the current user 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name for the current user.
	 * 
	 * @param lastName
	 * 			last name for the currently selected user
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the email address of the current user.
	 * 
	 * @return the email address of the given user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address for the current user.
	 * 
	 * @param email
	 * 			the email address to be used for the current user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
    
}