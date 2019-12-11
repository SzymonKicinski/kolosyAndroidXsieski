package com.example.grzesiek.projektinzynierka.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.grzesiek.projektinzynierka.R;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
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
        startActivity(new Intent(AuthorActivity.this, MainActivity.class));
    }

    public void loadWeight() {
        startActivity(new Intent(AuthorActivity.this, WeightActivity.class));
    }

    public void loadCircuit() {
        startActivity(new Intent(AuthorActivity.this, CircuitActivity.class));
    }

    public void loadInformation() {
        startActivity(new Intent(AuthorActivity.this, InformationActivity.class));
    }


    public void loadAuthor() {
        startActivity(new Intent(AuthorActivity.this, AuthorActivity.class));
    }

}
