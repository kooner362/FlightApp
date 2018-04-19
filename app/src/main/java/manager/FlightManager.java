package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import application.Flight;


/**
 * The FlightManager class is responsible for all flight related data. 
 * It stores data, retrieves data, and updates from external CSV file.
 * Also it allows for a User to add more flights.
 * 
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public class FlightManager {
	
	/**
	 * HashMap of all flights, the key being the Origin of a flight and the
	 * value being an ArrayList of Flight classes.
	 */
	private HashMap<String, ArrayList<Flight>> flights;
	
	/**
	 * Instantiates a new FlightManager class with the input being a 
	 * serializable file. If it does not exist it will be created.
	 * 
	 * @param filePath 
	 * 			location of serializable flight file.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public FlightManager(String filePath) throws ClassNotFoundException, IOException{
		flights = new HashMap<String, ArrayList<Flight>>();
        
        // Reads serializable objects from file.
        // Populates the record list using stored data, if it exists.
        File file = new File(filePath);
        if (file.exists()) {
            readFromFile(filePath);
        } else {
            file.createNewFile();
        }
	}

	/**
	 * Reads from a serialized file and deserializes all data
	 * into a HashMap of Flight classes.
	 * 
	 * @param filePath 
	 * 			Path of serialized file
	 * @throws ClassNotFoundException
	 */
	
	@SuppressWarnings("unchecked")
	private void readFromFile(String filePath) throws ClassNotFoundException{
		try {
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            //deserialize the Map
            flights = (HashMap<String, ArrayList<Flight>>) input.readObject();
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }    
		
	}
	
	/**
	 * Reads from a text file and adds each line to the HashMap as a Flight class
	 *  
	 * @param filePath 
	 *			text file formatted with one flight 
	 * 		   	per line in exactly this format: Number,DepartureDateTime,
	 *         	ArrivalDateTime,Airline,Origin,Destination,Price 
	 *         	(the dates are in the format YYYY-MM-DD; the
	 *         	price has exactly two decimal places)
	 * @throws FileNotFoundException
	 */
	public void readFromCSVFile(String filePath) throws FileNotFoundException {
        
        // FileInputStream can be used for reading raw bytes, like an image. 
        Scanner scanner = new Scanner(new FileInputStream(filePath));
        String[] record;

        while(scanner.hasNextLine()) {
            record = scanner.nextLine().split(",");
            Flight flight = new Flight(record[0], 
                    record[1], record[2], record[3], record[4], record[5], record[6]);
            addFlight(flight);
        }
        scanner.close();
    }
	
	/**
	 * Add Flight to existing flights.
	 *  
	 * @param flight 
	 * 			a Flight class
	 */
	public void addFlight(Flight flight){
		if (flights.containsKey(flight.getOrigin())){
        	if (!flights.get(flight.getOrigin()).contains(flight)){
            	flights.get(flight.getOrigin()).add(flight);
        	}
        }
        else if (!flights.containsKey(flight.getOrigin())){
        	ArrayList<Flight> initialList = new ArrayList<>();
            initialList.add(flight);
            flights.put(flight.getOrigin(), initialList);
        }
	}
	
	/**
	 * Returns a HashMap of all Flights.
	 * 
	 * @return a hashmap of all flights
	 */
	public HashMap<String, ArrayList<Flight>> getFlights(){
		return this.flights;
	}
	
	/**
	 * Saves the HashMap of Flights into a serialized file.
	 * 
	 * @param filePath 
	 *			path to serialized file
	 * @throws IOException
	 */
	public void saveToFile(String filePath) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(flights);
        output.close();
    }
}