package group_0698.flightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import manager.*;

public class AdminActivity extends AppCompatActivity {
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            email = null;
        }else{email=extras.getString("email");}
    }

    public void uploadClients(View view) {
        try{
            ClientManager cm = new ClientManager(this.getApplicationContext().getFilesDir().getPath() + "/clients.ser");
            cm.readFromCSVFile(this.getApplicationContext().getFilesDir().getPath() + "/clients.txt");
            cm.saveToFile(this.getApplicationContext().getFilesDir().getPath() + "/clients.ser");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void uploadFlights(View view) {
        try{
            FlightManager fm = new FlightManager(this.getApplicationContext().getFilesDir().getPath() + "/flights.ser");
            fm.readFromCSVFile(this.getApplicationContext().getFilesDir().getPath() + "/flights.txt");
            fm.saveToFile(this.getApplicationContext().getFilesDir().getPath() + "/flights.ser");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
