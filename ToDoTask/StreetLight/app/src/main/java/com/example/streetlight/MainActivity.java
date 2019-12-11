package com.example.streetlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button redButton;
    Button greenButton;
    Button yellowButton;
    ImageView imageView3;
    ImageView imageView2;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redButton = (Button) findViewById(R.id.redButton);
        greenButton = (Button) findViewById(R.id.greenButton);
        yellowButton = (Button) findViewById(R.id.yellowButton);

        imageView1 = (ImageView) findViewById(R.id.offLight1);
        imageView2 = (ImageView) findViewById(R.id.offLight2);
        imageView3 = (ImageView) findViewById(R.id.offLight3);
    }


    public void onClick(View v) {
        if ( v == redButton && v != yellowButton && v != greenButton ) {
            imageView1.setImageResource(R.drawable.red_on);
            imageView2.setImageResource(R.drawable.light_off);
            imageView3.setImageResource(R.drawable.light_off);

        }
        if ( v != redButton && v == yellowButton && v != greenButton ) {
            imageView2.setImageResource(R.drawable.yellow_on);
            imageView1.setImageResource(R.drawable.light_off);
            imageView3.setImageResource(R.drawable.light_off);
        }
        if ( v != redButton && v != yellowButton && v == greenButton ) {
            imageView3.setImageResource(R.drawable.green_on);
            imageView2.setImageResource(R.drawable.light_off);
            imageView1.setImageResource(R.drawable.light_off);
        }

    }


}
