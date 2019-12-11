package com.example.figury2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class kwadratActivity extends AppCompatActivity {

    private Button mainActivity_GoBack;
    private Button button_Oblicz;
    private Button kwadratObliczBtn;
    private EditText wartoscA;
    private EditText wynik_kwadrat_wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kwadrat);


        mainActivity_GoBack = (Button) findViewById(R.id.kwadrat_button_back);
        kwadratObliczBtn = (Button) findViewById(R.id.kwadrat_Oblicz);
        wartoscA = (EditText)findViewById(R.id.kwadrat_wartosc_a);
        wynik_kwadrat_wynik = (EditText)findViewById(R.id.kwadrat_wynik);

        mainActivity_GoBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        kwadratObliczBtn.setOnClickListener(
                new View.OnClickListener()
        {
            public void onClick(View view) {
                Integer wartoscA_Value_Int = Integer.parseInt(wartoscA.getText().toString());
                int nIntFormEt = new Integer(wartoscA_Value_Int * wartoscA_Value_Int.intValue());
                wynik_kwadrat_wynik.setText(""+nIntFormEt);
//                int wartoscA_Value = Integer.parseInt(wartoscA.toString());
//                wynik_kwadrat_wynik = wartoscA_Value * wartoscA_Value;
                Log.v("Wartosc a:", wynik_kwadrat_wynik.toString());
            }
        });

    }


}
