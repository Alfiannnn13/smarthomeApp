package com.example.smarthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.security.keystore.KeyInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        navigationView = findViewById(R.id.buttom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new DashboardFragment()). commit();


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null ;
                switch (item.getItemId()){
                    case R.id.nav_dashboard:
                        fragment = new DashboardFragment();
                        break;

                    case R.id.nav_auto:
                        fragment = new AutomaticFragment();
                        break;

                    case R.id.nav_monitoring:
                        fragment = new MonitoringFragment();
                        break;

                    case R.id.nav_feedback:
                        fragment = new FeedbackFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment). commit();

                return true;
            }
        });



    }
    public void Terrace (View view) {
        Intent intent = new Intent(Home.this,Terrace.class);
        startActivity(intent);
    }
    public  void LivingRoom (View view) {
        Intent intent = new Intent(Home.this, LivingRoom.class);
        startActivity(intent);
    }
    public void AlfianRoom (View view){
        Intent intent = new Intent(Home.this, AlfianRoom.class);
        startActivity(intent);
    }
    public  void BackBedroom (View view) {
        Intent intent = new Intent(Home.this, BackBedroom.class);
        startActivity(intent);
    }
    public void Kitchen (View view) {
        Intent intent = new Intent(Home.this, kitchen.class);
        startActivity(intent);
    }

    public void PetFeeder (View view) {
        Intent intent = new Intent(Home.this, PetFeeder.class);
        startActivity(intent);
    }
}