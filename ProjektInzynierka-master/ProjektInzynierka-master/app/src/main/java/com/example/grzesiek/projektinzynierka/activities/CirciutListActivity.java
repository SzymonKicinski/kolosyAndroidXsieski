package com.example.grzesiek.projektinzynierka.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.grzesiek.projektinzynierka.R;
import com.example.grzesiek.projektinzynierka.database.DatabaseHandler;
import com.example.grzesiek.projektinzynierka.domain.Circuit;
import com.example.grzesiek.projektinzynierka.domain.Weight;

import java.util.ArrayList;
import java.util.List;

public class CirciutListActivity extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuit_list);
        DatabaseHandler db = new DatabaseHandler(this);
        list = findViewById(R.id.circuit_list);


        List<String> dane = new ArrayList<>();

        List<Circuit> circuits = db.getAllCircuit();

        for (Circuit ct : circuits) {
            String record = "Nr pomiaru: " + ct.getId() + "    data pomiaru: " + ct.getYear() + "." + ct.getMonth() + "." + ct.getDay() +
                    "\n" + "obw. klatki: " + ct.getChest() + "cm" + "    obw. pasa: " + ct.getWaist() + "cm";
            dane.add(record);
        }

        list.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, R.id.row, dane));
    }

}