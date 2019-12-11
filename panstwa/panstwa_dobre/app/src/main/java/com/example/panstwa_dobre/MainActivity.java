package com.example.panstwa_dobre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView list ;
    private ArrayAdapter<String> adapter ;
    private String countries_short[];
    private String countries_long[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView1);

        countries_short =
                getResources().getStringArray
                        (R.array.shortcuts_array);
        ArrayList<String> count_list = new ArrayList<String>();
        count_list.addAll( Arrays.asList(countries_short) );

        countries_long =
                getResources().getStringArray
                        (R.array.countries_array);

        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.row, count_list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
        TextView pokaz = (TextView) findViewById(R.id.name);
        pokaz.setText(countries_long[position]);
    }
}
