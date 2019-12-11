package com.example.grzesiek.projektinzynierka.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.grzesiek.projektinzynierka.database.DatabaseHandler;
import com.example.grzesiek.projektinzynierka.R;
import com.example.grzesiek.projektinzynierka.domain.Circuit;
import com.example.grzesiek.projektinzynierka.domain.Information;
import com.example.grzesiek.projektinzynierka.domain.Weight;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView newInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newInformation = (TextView) findViewById(R.id.informationTextView);

        DatabaseHandler db = new DatabaseHandler(this);


        List<Information> information = db.getAllInformation();
        for (Information inf : information) {
            newInformation.setText("Witaj " + inf.getName() + "! \n \n "
                    + "Przy swoim wzroscie równym " + inf.getHeight() + " cm i"
                    + " w wieku " + inf.getAge() + " ważysz na start " + inf.getWeight()
                    + " kg. \n \n Jednak Twoim celem jest osiągnięcie wagi równej "
                    + inf.getTargetWeight() + " kg."
                    + "\n \n Życzę Ci powodzenia i wytrwałości w dążeniu do celu!");
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start:
                loadMain();
                return true;
            case R.id.waga:
                loadWeight();
                return true;
            case R.id.pomiary:
                loadCircuit();
                return true;
            case R.id.informacje:
                loadInformation();
                return true;
            case R.id.oAutorze:
                loadAuthor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadMain() {
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }

    public void loadWeight() {
        startActivity(new Intent(MainActivity.this, WeightActivity.class));
    }

    public void loadCircuit() {
        startActivity(new Intent(MainActivity.this, CircuitActivity.class));
    }

    public void loadInformation() {
        startActivity(new Intent(MainActivity.this, InformationActivity.class));
    }

    public void loadAuthor() {
        startActivity(new Intent(MainActivity.this, AuthorActivity.class));
    }
}

