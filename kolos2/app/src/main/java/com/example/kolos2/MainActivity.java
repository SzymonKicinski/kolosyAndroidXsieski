package com.example.kolos2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Button
    Button buttonChecker;
    EditText checkNumeber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button
        buttonChecker = (Button) findViewById(R.id.buttonChecker);

        checkNumeber = (EditText) findViewById(R.id.checkNumber);
        // Parsowanie na double


        //Listner
        buttonChecker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final Integer checkNumberParsed = Integer.parseInt(checkNumeber.getText().toString());
                checkIfNumberIsPrime(checkNumberParsed);
            }
        });
    }

    public void checkIfNumberIsPrime(int n) {

        int i, m = 0, flag = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            alertBad();
            System.out.println(n + " is not prime number");
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    alertBad();
                    System.out.println(n + " is not prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                alertGood();
                System.out.println(n + " is prime number");
            }
        }

    }

    public void alertGood() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Podana liczba jest liczba pierwsza");
        alertDialog.setMessage("Brawo");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void alertBad() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Liczba nie jest liczba pierwsza");
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
