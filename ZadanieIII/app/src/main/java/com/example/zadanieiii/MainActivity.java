package com.example.zadanieiii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    public Button btn_check_the_value;
    public Button btn_random_number;
    public EditText ed_result_of_chance;
    public EditText ed_value_of_more_or_less;
    public EditText ed_valoue_of_chance;
    public EditText ed_more_or_less;
    public EditText ed_count_of_chance;
    public EditText ed_set_in_number_to_check;

    // Liczba do zgadnięcia
    public int numberToCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //    mainActivity_GoBack = (Button) findViewById(R.id.kwadrat_button_back);
        btn_check_the_value = (Button) findViewById(R.id.check_the_value);
        btn_random_number = (Button) findViewById(R.id.random_number);
        ed_valoue_of_chance = (EditText) findViewById(R.id.valoue_of_chance);
        ed_value_of_more_or_less= (EditText) findViewById(R.id.value_of_more_or_less);
        ed_set_in_number_to_check = (EditText) findViewById(R.id.set_in_number_to_check);



        btn_random_number.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = -2000;
                int max = 2000;
//                int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                int randomNum = (int) ((Math.random() * ((max - min) + 1)) + min);
                numberToCheck = randomNum;
            }
        });

        btn_check_the_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer int_ed_set_in_number_to_check = Integer.parseInt(ed_set_in_number_to_check.getText().toString());
                Integer int_ed_valoue_of_chance = Integer.parseInt(ed_valoue_of_chance.getText().toString());

                // Counter of chance
                int_ed_valoue_of_chance++;
                ed_valoue_of_chance.setText(""+int_ed_valoue_of_chance);

                if ( int_ed_set_in_number_to_check > numberToCheck ) {
                    ed_value_of_more_or_less.setText("Liczba jest mniejsza");
                }
                if ( int_ed_set_in_number_to_check < numberToCheck ) {
                    ed_value_of_more_or_less.setText("Liczba jest większa");
                }
                if ( int_ed_set_in_number_to_check == numberToCheck) {
                    ed_value_of_more_or_less.setText("Hurra! Udało się!");
                }
                if ( int_ed_set_in_number_to_check != null) {
//                    Snackbar mySnackbar = Snackbar.make(view, stringId, duration);
                }


            }
        });
    }



}
