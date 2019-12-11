package com.example.figury2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button kwadrat_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Button btn = (Button)findViewById(R.id.kwadrat_button);

        kwadrat_button = (Button) findViewById(R.id.kwadrat_button);

        kwadrat_button.setOnClickListener( new View.OnClickListener() {
          @Override
          public  void onClick(View view) {
              kwadratActivity();
          };
        });
    }

    private void kwadratActivity(){
        Intent intent = new Intent(this, kwadratActivity.class);
        startActivity(intent);
    };



}
