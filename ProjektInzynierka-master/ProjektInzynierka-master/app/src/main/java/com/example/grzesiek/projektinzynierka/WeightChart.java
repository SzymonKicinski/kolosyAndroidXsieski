package com.example.grzesiek.projektinzynierka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.grzesiek.projektinzynierka.database.DatabaseHandler;
import com.example.grzesiek.projektinzynierka.domain.Weight;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;


public class WeightChart extends AppCompatActivity {
    LineChart lineChart;
    float data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_chart);
        lineChart = (LineChart) findViewById(R.id.lineChart);
        DatabaseHandler db = new DatabaseHandler(this);

        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();

        List<Weight> weights = db.getAllWeight();

        for (Weight wg : weights) {
            data = (float) wg.getWeight();
            entries.add(new Entry(data ,wg.getId()-1));
            labels.add(" ");
    }

        LineDataSet dataSet = new LineDataSet(entries, "Wykres zmiany wagi");

        LineData data = new LineData(labels, dataSet);

        lineChart.setData(data);
        lineChart.setDescription("Pomiary wagi");

    }
}
