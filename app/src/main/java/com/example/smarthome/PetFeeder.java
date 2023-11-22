package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PetFeeder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_feeder);
    }

    public void Cat (View view) {
        Intent intent = new Intent(PetFeeder.this,PetFeederCat.class);
        startActivity(intent);
    }

    public void Fish (View view) {
        Intent intent = new Intent(PetFeeder.this,PetFeederCat.class);
        startActivity(intent);
    }
}