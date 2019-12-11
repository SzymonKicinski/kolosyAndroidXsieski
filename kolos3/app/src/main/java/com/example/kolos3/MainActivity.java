package com.example.kolos3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Stat
    Button start;
    // Buttony gra
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startGame);

        final Integer Button= R.id.button;
        final Integer Button2= R.id.button2;
        final Integer Button3= R.id.button3;
        final Integer Button4= R.id.button4;
        final Integer Button5= R.id.button5;
        final Integer Button6= R.id.button6;
        final Integer Button7= R.id.button7;
        final Integer Button8= R.id.button8;
        final Integer Button9= R.id.button9;
        final Integer Button10= R.id.button11;
        final Integer Button11= R.id.button12;
        final Integer button12 = R.id.button13;


        // -----------------------------
        final Integer[] button = {
                Button,
                Button2,
                Button3,
                Button4,
                Button5,
                Button6,
                Button7,
                Button8,
                Button9,
                Button10,
                Button11,
                button12
        };
        // -----------------------------


        //Listner
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
                button10.setText("");
                button11.setText("");
                button12.setText("");
            }
        });


        String[] nameOfCountre = new String[11];
        for (int i = 0; i < nameOfCountre.length ; i ++ ) {
            int country = getBackNumberOfCountry();

                if ( i == 0 || i == 1) {

                }
                if ( country == 0) {
                    nameOfCountre[i] = "Lotwa";
                }
                if ( country == 0) {
                    nameOfCountre[i] = "Niemcy";
                }
                if ( country == 0) {
                    nameOfCountre[i] = "Czechy";
                }
                if ( country == 0) {
                    nameOfCountre[i] = "Litwa";
                }
                if ( country == 0) {
                    nameOfCountre[i] = "Rosja";
                }
        }

    }

    public int getBackNumberOfCountry () {
        int min = 0;
        int max = 5;
//                int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
