package com.example.grzesiek.projektinzynierka.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grzesiek.projektinzynierka.CircuitChart;
import com.example.grzesiek.projektinzynierka.CircuitChart2;
import com.example.grzesiek.projektinzynierka.WeightChart;
import com.example.grzesiek.projektinzynierka.database.DatabaseHandler;
import com.example.grzesiek.projektinzynierka.utils.InputFilterMinMax;
import com.example.grzesiek.projektinzynierka.R;
import com.example.grzesiek.projektinzynierka.domain.Circuit;

public class CircuitActivity extends AppCompatActivity {
    private Button buttonCircuitList, buttonSaveCircuit, buttonDeleteCircuit, buttonChart, buttonChart2;
    private EditText dayEditText, monthEditText, yearEditText, chestEditText, waistEditText, idEditText;
    private int day, month, year, id;
    private double chest, waist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuit);

        final DatabaseHandler db = new DatabaseHandler(this);

        buttonCircuitList = (Button) findViewById(R.id.buttonWeightList);
        buttonSaveCircuit = (Button) findViewById(R.id.buttonSaveWeight);
        buttonDeleteCircuit = (Button) findViewById(R.id.buttonDeleteCircuit);
        buttonChart = (Button) findViewById(R.id.buttonChart);
        buttonChart2 = (Button) findViewById(R.id.buttonChart2);

        dayEditText = (EditText) findViewById(R.id.dayEditText);
        dayEditText.setFilters(new InputFilter[]{new InputFilterMinMax("1","31")});
        monthEditText = (EditText) findViewById(R.id.monthEditText);
        monthEditText.setFilters(new InputFilter[]{new InputFilterMinMax("1","12")});
        yearEditText = (EditText) findViewById(R.id.yearEditText);
        chestEditText = (EditText) findViewById(R.id.chestEditText);
        waistEditText = (EditText) findViewById(R.id.waistEditText);
        idEditText = (EditText) findViewById(R.id.idEditText);


        buttonCircuitList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CircuitActivity.this, CirciutListActivity.class));

            }
        });

        buttonChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CircuitActivity.this, CircuitChart.class));
            }
        });

        buttonChart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CircuitActivity.this, CircuitChart2.class));
            }
        });

        buttonSaveCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    day = Integer.parseInt(dayEditText.getText().toString());
                    month = Integer.parseInt(monthEditText.getText().toString());
                    year = Integer.parseInt(yearEditText.getText().toString());
                    chest = Double.parseDouble(chestEditText.getText().toString());
                    waist = Double.parseDouble(waistEditText.getText().toString());

                    db.addCircuit(new Circuit(year, month, day, chest, waist));

                    Toast toast = Toast.makeText(CircuitActivity.this, "Operacja dodawania przebiegła pomyślnie", Toast.LENGTH_SHORT);
                    toast.show();
                }catch (Exception e) {
                    Toast toast = Toast.makeText(CircuitActivity.this, "Nastąpił błąd przy dodawaniu danych", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });


        buttonDeleteCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    id = Integer.parseInt(idEditText.getText().toString());
                    db.deleteCircuit(new Circuit(id));

                    Toast toast = Toast.makeText(CircuitActivity.this, "Został usunięty wpis o podanym numerze", Toast.LENGTH_SHORT);
                    toast.show();
                }catch (Exception e) {
                    Toast toast = Toast.makeText(CircuitActivity.this, "Podaj numer pomiaru do usunięcia", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

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
        startActivity(new Intent(CircuitActivity.this, MainActivity.class));
    }

    public void loadWeight() {
        startActivity(new Intent(CircuitActivity.this, WeightActivity.class));
    }

    public void loadCircuit() {
        startActivity(new Intent(CircuitActivity.this, CircuitActivity.class));
    }

    public void loadInformation() {
        startActivity(new Intent(CircuitActivity.this, InformationActivity.class));
    }


    public void loadAuthor() {
        startActivity(new Intent(CircuitActivity.this, AuthorActivity.class));
    }
}
