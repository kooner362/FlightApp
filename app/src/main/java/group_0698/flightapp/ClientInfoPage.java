package group_0698.flightapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import java.io.IOException;

import application.NoSuchClientException;
import manager.ClientManager;

public class ClientInfoPage extends AppCompatActivity {
    private String email;
    private ClientManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_info_page);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            email = null;
        } else {
            email = extras.getString("email");
        }
        try {
            cm = new ClientManager(this.getApplicationContext().getFilesDir() + "/clients.ser");
            TextView lastName =  (TextView) findViewById(R.id.last_name);
            TextView firstName =  (TextView) findViewById(R.id.first_name);
            TextView email_address =  (TextView) findViewById(R.id.email);
            TextView address =  (TextView) findViewById(R.id.address);
            TextView creditCard =  (TextView) findViewById(R.id.credit_card);
            TextView expiry =  (TextView) findViewById(R.id.expiry);
            lastName.setText(cm.getClient(email).getLastName());
            firstName.setText(cm.getClient(email).getFirstName());
            email_address.setText(cm.getClient(email).getEmail());
            address.setText(cm.getClient(email).getAddress());
            creditCard.setText(cm.getClient(email).getCreditCardNumber());
            expiry.setText(cm.getClient(email).getExpiryDate());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchClientException e1){
            e1.printStackTrace();
        }

    }
    public void setInfo(View View){
        try {
            cm = new ClientManager(this.getApplicationContext().getFilesDir() + "/clients.ser");
            TextView lastName =  (TextView) findViewById(R.id.last_name);
            TextView firstName =  (TextView) findViewById(R.id.first_name);
            TextView email_address =  (TextView) findViewById(R.id.email);
            TextView address =  (TextView) findViewById(R.id.address);
            TextView creditCard =  (TextView) findViewById(R.id.credit_card);
            TextView expiry =  (TextView) findViewById(R.id.expiry);
            cm.getClient(email).setLastName(lastName.getText().toString());
            cm.getClient(email).setFirstName(firstName.getText().toString());
            cm.getClient(email).setEmail(email_address.getText().toString());
            cm.getClient(email).setAddress(address.getText().toString());
            cm.getClient(email).setCreditCardNumber(creditCard.getText().toString());
            cm.getClient(email).setExpiryDate(expiry.getText().toString());
            cm.saveToFile(this.getApplicationContext().getFilesDir() + "/clients.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchClientException e1){
            e1.printStackTrace();
        }
    }
}
