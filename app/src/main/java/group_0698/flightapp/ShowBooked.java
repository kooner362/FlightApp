package group_0698.flightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import application.NoSuchClientException;
import manager.ClientManager;
import application.Itinerary;

public class ShowBooked extends AppCompatActivity {
    private String email;
    private ArrayList<Itinerary> booked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_booked);
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            email = null;
        }else{email= extras.getString("email");}
        try{
            ClientManager clientManager = new ClientManager(this.getApplicationContext().getFilesDir() + "/client.ser");
            booked = clientManager.getClient(email).getBookedItineraries();
        }catch (NoSuchClientException | ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Itinerary> adapter = new ArrayAdapter<Itinerary>(this, R.layout.sresults, booked);
        listView.setAdapter(adapter);
    }
}
