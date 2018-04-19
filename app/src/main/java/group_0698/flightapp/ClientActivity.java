package group_0698.flightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;

public class ClientActivity extends AppCompatActivity {
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            email = null;
        }else{email= extras.getString("email");}
    }
    public void viewInfo(View view){
        Intent intent = new Intent(this, ClientInfoPage.class);
        intent.putExtra("email", email);
        startActivity(intent);

    }
    public void searchPage(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    public void searchFlight(View view){
        Intent intent = new Intent(this, SearchFlight.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    public void showBooked(View view){
        Intent intent = new Intent(this, ShowBooked.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}
