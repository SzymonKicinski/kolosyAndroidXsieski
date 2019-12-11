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

import com.example.grzesiek.projektinzynierka.WeightChart;
import com.example.grzesiek.projektinzynierka.database.DatabaseHandler;
import com.example.grzesiek.projektinzynierka.utils.InputFilterMinMax;
import com.example.grzesiek.projektinzynierka.R;
import com.example.grzesiek.projektinzynierka.domain.Weight;

public class WeightActivity extends AppCompatActivity  {
    private Button buttonWeightList, buttonSaveWeight, buttonDeleteWeight, buttonChart;
    private EditText dayEditText, monthEditText, yearEditText, weightEditText, idEditText;
    private int day, month, year,id;
    private double weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        final DatabaseHandler db = new DatabaseHandler(this);

        buttonWeightList = (Button) findViewById(R.id.buttonWeightList);
        buttonSaveWeight = (Button) findViewById(R.id.buttonSaveWeight);
        buttonDeleteWeight = (Button) findViewById(R.id.buttonDeleteWeight);
        buttonChart = (Button) findViewById(R.id.buttonChart);

        dayEditText = (EditText) findViewById(R.id.dayEditText);
        dayEditText.setFilters(new InputFilter[]{new InputFilterMinMax("1","31")});
        monthEditText = (EditText) findViewById(R.id.monthEditText);
        monthEditText.setFilters(new InputFilter[]{new InputFilterMinMax("1","12")});
        yearEditText = (EditText) findViewById(R.id.yearEditText);
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        idEditText = (EditText) findViewById(R.id.idEditText);

        buttonWeightList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeightActivity.this, WeightListActivity.class));

            }
        });

        buttonChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeightActivity.this, WeightChart.class));
            }
        });

        buttonDeleteWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    id = Integer.parseInt(idEditText.getText().toString());
                    db.deleteWeight(new Weight(id));

                    Toast toast = Toast.makeText(WeightActivity.this, "Został usunięty wpis o podanym numerze", Toast.LENGTH_SHORT);
                    toast.show();
                }catch (Exception e) {
                    Toast toast = Toast.makeText(WeightActivity.this, "Podaj numer pomiaru do usunięcia", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        buttonSaveWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    day = Integer.parseInt(dayEditText.getText().toString());
                    month = Integer.parseInt(monthEditText.getText().toString());
                    year = Integer.parseInt(yearEditText.getText().toString());
                    weight = Double.parseDouble(weightEditText.getText().toString());

                    db.addWeight(new Weight(year, month, day, weight));
                    Toast toast = Toast.makeText(WeightActivity.this, "Operacja dodawania przebiegła pomyślnie", Toast.LENGTH_SHORT);
                    toast.show();
                }catch (Exception e) {
                    Toast toast = Toast.makeText(WeightActivity.this, "Nastąpił błąd przy dodawaniu danych", Toast.LENGTH_SHORT);
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
        startActivity(new Intent(WeightActivity.this, MainActivity.class));
    }

    public void loadWeight() {
        startActivity(new Intent(WeightActivity.this, WeightActivity.class));
    }

    public void loadCircuit() {
        startActivity(new Intent(WeightActivity.this, CircuitActivity.class));
    }

    public void loadInformation() {
        startActivity(new Intent(WeightActivity.this, InformationActivity.class));
    }


    public void loadAuthor() {
        startActivity(new Intent(WeightActivity.this, AuthorActivity.class));
    }
}

