package group_0698.flightapp;

import manager.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    private FlightManager fm;
    private ClientManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logIn(View view) {

        // Gets the first name from the 1st EditText field.
        EditText userNameField = (EditText) findViewById(R.id.username);
        String userName = userNameField.getText().toString();

        // Gets the last name from the 2nd EditText field.
        EditText passwordField = (EditText) findViewById(R.id.password);
        String password = passwordField.getText().toString();
        String name = userName + "," + password + "," + "admin";
        String name2 = userName + "," + password + "," + "client";
        boolean result = false;
        boolean admin = false;

        try {
            // Create a File object for a file named somefile in the directory
            // we got above.
            //File clients = new File(this.getApplicationContext().getFilesDir().getPath() + "/clients.ser");
            //if (!clients.exists()){
            //    try {
            //        clients.createNewFile();
            //    }catch (IOException e){
            //        e.printStackTrace();
            //}
            // }
            //cm = new ClientManager(this.getApplicationContext().getFilesDir().getPath() + "/clients.ser");
            //fm = new FlightManager(this.getApplicationContext().getFilesDir().getPath() + "/clients.ser");
            File dataDir = this.getApplicationContext().getFilesDir();
            String record;
            System.out.println(dataDir);
            File passwords = new File(dataDir, "passwords.txt");
            Scanner scanner = new Scanner(new FileInputStream(passwords));
            while (scanner.hasNextLine() && !(result)) {
                record = scanner.nextLine();
                System.out.println(record);
                if (record.equals(name)) {
                    result = true;
                    admin = true;
                } else if (record.equals(name2)) {
                    result = true;
                }
            }
            scanner.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println(result);
        if (result && admin){
            Intent intent = new Intent(this, AdminActivity.class);
            // Attaches the name object to this intent, under the key "studentKey".
            // Starts ShowActivity.
            intent.putExtra("email", userName);
            startActivity(intent);

        }
        else if(result && !(admin)){
            Intent intent = new Intent(this, SearchActivity.class);
            // Attaches the name object to this intent, under the key "studentKey".
            // Starts ShowActivity.
            intent.putExtra("email", userName);
            startActivity(intent);
        }


    }
}
