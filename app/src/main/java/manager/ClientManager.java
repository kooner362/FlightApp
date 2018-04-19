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
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import application.Client;
import application.NoSuchClientException;

/**
 * The ClientManager class is responsible for all client related data. 
 * It stores data, retrieves data, and updates from external file.
 * Also it allows for a User to add more clients.
 * @author Jia Ning Gan 
 * @author Samer Hachem
 * @author Niyant Hathi 
 * @author Gurpreet Kooner.
 * @version 1.0
 */
public class ClientManager {
	
	/**
	 * HashMap of all clients, the key being the email of a client and the
	 * value being an ArrayList of the specific clients Client class.
	 */
	private Map<String, ArrayList<Client>> clients;
	
	/**
	 * Instantiates a new ClientManager class with the input being a 
	 * serializable file. If it does not exist it will be created.
	 * 
	 * @param filePath 
	 * 			location of serializable client file.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ClientManager(String filePath) throws ClassNotFoundException, IOException{
		clients = new HashMap<String, ArrayList<Client>>();
        
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
	 * into a HashMap of Client classes.
	 * 
	 * @param filePath 
	 * 			Path to serialized file.
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private void readFromFile(String filePath) throws ClassNotFoundException{
		try {
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            //deserialize the Map
            clients = (Map<String, ArrayList<Client>>) input.readObject();
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }    
		
	}
	
	/**
	 * Reads from a text file and adds each line to the HashMap
	 * as a Client class.
	 *  
	 * @param filePath 
	 * 			text file formatted with one client per line in exactly this:
	 * 			format: lastName,firstName,email,address,creditcardnumber,
	 *          expirydate (the date is in the format YYYY-MM-DD;)
	 * @throws FileNotFoundException
	 */
	public void readFromCSVFile(String filePath) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(new FileInputStream(filePath));
        String[] record;

        while(scanner.hasNextLine()) {
            record = scanner.nextLine().split(",");
            Client client = new Client(record[0], 
                    record[1], record[2], record[3], record[4], record[5]);

            ArrayList<Client> initialList = new ArrayList<>();
            initialList.add(client);
            clients.put(client.getEmail(), initialList);
        }
        scanner.close();
    }
	
	/**
	 * Add Client to existing clients. 
	 * 
	 * @param client 
	 * 			a client class
	 */
	public void addClient(Client client){
		ArrayList<Client> initialList = new ArrayList<>();
        initialList.add(client);
        clients.put(client.getEmail(), initialList);
	}
	
	/**
	 * Returns a Set of all client emails.
	 * 
	 * @return a set of all client emails
	 */
	public Set<String> getClients(){
		return this.clients.keySet();
	}
	
	/**
	 * Return a Client class which has email as a key.
	 * 
	 * @param email
	 * 			email address of the current user
	 * @return a Client class which has email as key.
	 */
	public Client getClient(String email) throws NoSuchClientException{
		if (this.clients.containsKey(email)){
			return this.clients.get(email).get(0);
		}
		else{throw new NoSuchClientException();}
	}
	
	/**
	 * Saves the HashMap of Clients into a serialized file.
	 * 
	 * @param filePath 
	 * 			path of serialized file
	 * @throws IOException
	 */
	public void saveToFile(String filePath) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(clients);
        output.close();
    }

}