package group_0698.flightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import application.NoSuchClientException;
import manager.ClientManager;
import manager.FlightManager;
import application.Client;
import application.Itinerary;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

public class SearchActivity extends AppCompatActivity {
    private String email;
    private int p;
    private ArrayList<Itinerary> results;
    private TextView date;
    private TextView origin;
    private TextView destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            email = null;
        } else {
            email = extras.getString("email");
        }
        itineraryClickListener();
        p = -1;
        date = (TextView) findViewById(R.id.departure_date);
        origin = (TextView) findViewById(R.id.origin);
        destination = (TextView) findViewById(R.id.destination);
    }

    public void search(View view){
        boolean checked_cost = ((RadioButton) findViewById(R.id.sort_by_cost)).isChecked();
        boolean checked_time = ((RadioButton) findViewById(R.id.sort_by_time)).isChecked();
        try{
            FlightManager fm = new FlightManager(this.getApplicationContext().getFilesDir() + "/flights.ser");
            Client client = new Client();
            results = client.searchItinerary(origin.getText().toString(),
                    date.getText().toString(), destination.getText().toString(), fm.getFlights());
            System.out.println(checked_cost);
            System.out.println(checked_time);
            if (checked_cost){
                client.searchItinerariesCost();
            }
            else if (checked_time){
                client.searchItinerariesTime();
            }
            ListView listView = (ListView) findViewById(R.id.listView);
            ArrayAdapter<Itinerary> adapter = new ArrayAdapter<Itinerary>(this, R.layout.sresults, results);
            listView.setAdapter(adapter);
        }catch (ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
    }
    private void itineraryClickListener() {
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                p = position;
            }
        });
    }
    public void bookItinerary(View view){
        try{
            ClientManager cm = new ClientManager(this.getApplicationContext().getFilesDir() + "/clients.ser");
            Client client = cm.getClient(email);
            client.setBookedItineraries(results.get(p));
            cm.saveToFile(this.getApplicationContext().getFilesDir() + "/clients.ser");
        }catch(IOException | ClassNotFoundException | NoSuchClientException e){
            e.printStackTrace();
        }
    }
}
