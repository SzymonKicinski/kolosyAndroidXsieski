package com.example.grzesiek.projektinzynierka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.grzesiek.projektinzynierka.database.DatabaseHandler;
import com.example.grzesiek.projektinzynierka.domain.Circuit;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class CircuitChart extends AppCompatActivity {
    LineChart lineChart;
    float dataChest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuit_chart);
        lineChart = (LineChart) findViewById(R.id.lineChart);


        DatabaseHandler db = new DatabaseHandler(this);

        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();

        List<Circuit> circuits = db.getAllCircuit();

        for (Circuit ct : circuits) {
        dataChest = (float) ct.getChest();
        entries.add(new Entry(dataChest, ct.getId()-1));
        labels.add(" ");
        }
        LineData chartData = new LineData();

        LineDataSet dataSet = new LineDataSet(entries, "Wykres zmiany obwodu klatki");
        LineData data = new LineData(labels, dataSet);
        chartData.addDataSet(dataSet);


        lineChart.setData(data);

        lineChart.setDescription("Pomiary obwodu klatki");


        }
        }
