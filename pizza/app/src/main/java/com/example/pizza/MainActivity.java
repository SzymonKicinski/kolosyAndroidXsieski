package com.example.pizza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    //    private ArrayAdapter<String> adapter ;
/*    private String countries_short[];
    private String countries_long[];*/

    //Detail order
    String detailsOrderIngredients;
    int ingredientsCounter;

    //Jakie ciasto
    RadioButton cienkieCiasto;
    RadioButton grubeCiasto;

    // Rozmiar
    RadioButton malyRozmiar;
    RadioButton sredniRozmiar;
    RadioButton duzyRozmiar;
    // Pay Button
    Button pay;


    ArrayList dataModels;
    ListView listView;
    private CustomerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        // init variable
        // Ciasto
        cienkieCiasto = (RadioButton) findViewById(R.id.cienkieCiasto);
        grubeCiasto = (RadioButton) findViewById(R.id.grubeCiasto);
        // Rozmiar
        malyRozmiar = (RadioButton) findViewById(R.id.malyRozmiar);
        sredniRozmiar = (RadioButton) findViewById(R.id.sredniRozmiare);
        duzyRozmiar = (RadioButton) findViewById(R.id.duzyRozmiar);

        //Layout ListView

        dataModels = new ArrayList();

        dataModels.add(new DataModel("Szynka - podstawowy 2zł", false));
        dataModels.add(new DataModel("Ser - podsatwowy 2zł", false));
        dataModels.add(new DataModel("Pieczarki - podsatwowy 2zł", false));
        dataModels.add(new DataModel("Oliwki - podsatwowy 2zł", true)); // TRUE
        dataModels.add(new DataModel("Boczek - podsatwowy 2zł", true)); // TRUE
        dataModels.add(new DataModel("Kurczak - podsatwowy 2zł", true)); // TRUE
        dataModels.add(new DataModel("Cebula - podsatwowy 2zł", true)); // TRUE
        dataModels.add(new DataModel("Czosnek - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Salami - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Krewetki - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Kapary - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Tuńczyk - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Sos - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Pomidory - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Sos czosnkowy - dodatkowy 2,50zł", false));
        dataModels.add(new DataModel("Oregano - dodatkowy 2,50zł", false));


        adapter = new CustomerAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                DataModel dataModel = (DataModel) dataModels.get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();


            }
        });

        pay = (Button) findViewById(R.id.buttonPay);
        // Losuj button
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Init pay
                pay(v);

            }
        });
    }

    public void pay(View v) {
        int totalAmountForPizza = 0;
        String orderString;

        // Licz kaskę
        // Jakie ciasto?
        if (cienkieCiasto.isChecked()) {
            totalAmountForPizza += 16;
            orderString = "Pizza na cienkim cieście";
        } else if (grubeCiasto.isChecked()) {
            totalAmountForPizza += 20;
            orderString = "Pizza na cienkim grubym";
        }
        // Rozmiar
        if (sredniRozmiar.isChecked()) {
            totalAmountForPizza += 2;
            orderString = "Pizza na cienkim cieście o średnim rozmiarze";
        } else if (duzyRozmiar.isChecked()) {
            totalAmountForPizza += 4;
            orderString = "Pizza na cienkim cieście o malym rozmiarze";
        } else {
            orderString = "Pizza na cienkim cieście o duzym rozmiarze";
        }
        for (int i = 0; i < 16; i++) {
            DataModel dataModel = (DataModel) dataModels.get(i);
            if (dataModel.checked) {
                if (dataModel.name.contains("podsatwowy")) {
                    this.detailsOrderIngredients += dataModel.name;
                    totalAmountForPizza += 2;
                    ingredientsCounter++;
                }
                if (dataModel.name.contains("dodatkowy")) {
                    detailsOrderIngredients += dataModel.name;
                    totalAmountForPizza += 2.5;
                }
            }
        }

        //Validator
        // Init variable
        if ( ingredientsCounter >=3 ) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Order received");
            alertDialog.setMessage(orderString + this.detailsOrderIngredients + " amount to pay"+totalAmountForPizza+"." );
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            orderString = "";
            this.detailsOrderIngredients = "";
            totalAmountForPizza = 0;
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Complete your order");
            alertDialog.setMessage("Require minimum 3 basic ingredients");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "FATAL",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

    }

}
