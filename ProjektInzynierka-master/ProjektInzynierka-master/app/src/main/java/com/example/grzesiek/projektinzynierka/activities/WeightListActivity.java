package com.example.grzesiek.projektinzynierka.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.grzesiek.projektinzynierka.database.DatabaseHandler;
import com.example.grzesiek.projektinzynierka.R;
import com.example.grzesiek.projektinzynierka.domain.Circuit;
import com.example.grzesiek.projektinzynierka.domain.Information;
import com.example.grzesiek.projektinzynierka.domain.Weight;

import java.util.ArrayList;
import java.util.List;

public class WeightListActivity extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_list);
        DatabaseHandler db = new DatabaseHandler(this);
        list = findViewById(R.id.weight_list);

     //   prepareData(db);
        List<String> dane = new ArrayList<>();

        List<Weight> weights = db.getAllWeight();

        for (Weight wg : weights) {
            String record = "Nr pomiaru: " + wg.getId() + "     data pomiaru: " + wg.getYear() + "." + wg.getMonth() + "." + wg.getDay() + "\n" + "waga: " + wg.getWeight() + "kg";
            dane.add(record);
        }

        list.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, R.id.row, dane));
    }

    private void prepareData(DatabaseHandler db) {
        db.addInformation(new Information("Grzesiek", 184, 105.3, 90, 25));
        db.addWeight(new Weight(2018, 1, 8, 106.5));
        db.addWeight(new Weight(2018, 2, 25, 104.5));
        db.addWeight(new Weight(2018, 3, 12, 109.5));
        db.addWeight(new Weight(2018, 4, 6, 105.3));
        db.addCircuit(new Circuit(2018, 1, 8, 116.0, 117.5));
        db.addCircuit(new Circuit(2018, 2, 25, 110.0, 115.6));
        db.addCircuit(new Circuit(2018, 3, 12, 112.0, 114.7));
        db.addCircuit(new Circuit(2018, 4, 6, 117.0, 118.7));
    }

}