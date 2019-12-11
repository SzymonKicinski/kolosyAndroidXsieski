package com.example.kolos1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Button
    Button dodajBtn;
    Button odejmijBtn;
    Button mnozBtn;
    Button dzielBtn;

    //Lista
    ArrayList dataModels;
    ListView listView;
    private CustomerAdapter adapter;

    //Edittext Liczby
    public EditText liczbaA;
    public EditText liczbaB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lista
        listView = (ListView) findViewById(R.id.listView);


        //Init button
        dodajBtn = (Button) findViewById(R.id.dodajBtn);
        odejmijBtn = (Button) findViewById(R.id.odjemijBtn);
        dzielBtn = (Button) findViewById(R.id.dzielenieBtn);
        mnozBtn = (Button) findViewById(R.id.mnozenieBtn);

        // Liczby
        liczbaA = (EditText) findViewById(R.id.liczbaAText);
        liczbaB = (EditText) findViewById(R.id.liczbaBText);

        dataModels = new ArrayList();
        dataModels.add(new DataModel("Test"));
        dataModels.add(new DataModel("Test2"));

        adapter = new CustomerAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                DataModel dataModel = (DataModel) dataModels.get(position);
                adapter.notifyDataSetChanged();


            }
        });

        // onClick!!!!!!
        dodajBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Double parseLiczbaA = Double.parseDouble(liczbaA.getText().toString());
                Double parseLiczbaB = Double.parseDouble(liczbaB.getText().toString());
                dodaj(parseLiczbaA, parseLiczbaB);
            }
        });

        odejmijBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Double parseLiczbaA = Double.parseDouble(liczbaA.getText().toString());
                Double parseLiczbaB = Double.parseDouble(liczbaB.getText().toString());
                odejmowanie(parseLiczbaA, parseLiczbaB);
            }
        });

        dzielBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Double parseLiczbaA = Double.parseDouble(liczbaA.getText().toString());
                Double parseLiczbaB = Double.parseDouble(liczbaB.getText().toString());
                dziel(parseLiczbaA, parseLiczbaB);
            }
        });

        mnozBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Double parseLiczbaA = Double.parseDouble(liczbaA.getText().toString());
                Double parseLiczbaB = Double.parseDouble(liczbaB.getText().toString());
                mnozenie(parseLiczbaA, parseLiczbaB);
            }
        });


    }

    // Dodawnaie
    public void dodaj(double a, double b) {
        if (a > 0 && b > 0) {
            dataModels.add(new DataModel("" + (a + b)));
        } else {
            alert();
        }
    }

    //Odejmowanie
    public void odejmowanie(double a, double b) {
        if (a > 0 && b > 0 && a > b) {
            dataModels.add(new DataModel("" + (a - b)));
        } else {
            alert();
        }
    }

    //Dzielenie
    public void dziel(double a, double b) {
        if (a > 0 && b > 0 && a > b) {
            dataModels.add(new DataModel("" + (a / b)));
        } else {
            alert();
        }
    }

    //Mnozenie
    public void mnozenie(double a, double b) {
        if (a > 0 && b > 0 && a > b) {
            dataModels.add(new DataModel("" + (a * b)));
        } else {
            alert();
        }
    }

    public void alert() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Zle liczby ujemne lub a mniejsze od b!");
        alertDialog.setMessage("Blad!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}

