package com.example.smarthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AlfianRoom extends AppCompatActivity {

    TextView power1, power2, power3, power4;
    SwitchCompat monitor, laptop, smartphone, lamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfian_room);

        power1 = findViewById(R.id.powermonitor);
        power2 = findViewById(R.id.powerlaptopcharger);
        power3 = findViewById(R.id.powersmartphone);
        power4 = findViewById(R.id.powerlampAl);

        monitor = findViewById(R.id.SwitchMonitor);
        laptop = findViewById(R.id.SwitchLaptopCharger);
        smartphone = findViewById(R.id.SwitchSmartPhone);
        lamp = findViewById(R.id.SwitchLampAl);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Monitor = database.getReference("Monitor");
        DatabaseReference Laptop = database.getReference("Laptop");
        DatabaseReference Smartphone = database.getReference("Smartphone");
        DatabaseReference Lamp = database.getReference("LampuAlfian");

        Monitor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0) {
                    monitor.setChecked(false);
                    power1.setText("OFF");
                }else {
                    monitor.setChecked(true);
                    power1.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Laptop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0) {
                    laptop.setChecked(false);
                    power2.setText("OFF");
                } else {
                    laptop.setChecked(true);
                    power2.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Smartphone.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message =snapshot.getValue(long.class);
                if (message == 0){
                    smartphone.setChecked(false);
                    power3.setText("OFF");
                } else {
                    smartphone.setChecked(true);
                    power3.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Lamp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0){
                    lamp.setChecked(false);
                    power4.setText("OFF");
                }else {
                    lamp.setChecked(true);
                    power4.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (monitor.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("Monitor");
                    myref.setValue(1);
                } else {
                    DatabaseReference myref = database.getReference("Monitor");
                    myref.setValue(0);
                }
            }
        });

        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (laptop.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("Laptop");
                    myref.setValue(1);
                } else  {
                    DatabaseReference myref = database.getReference("Laptop");
                    myref.setValue(0);
                }
            }
        });

        smartphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (smartphone.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("Smartphone");
                    myref.setValue(1);
                } else {
                    DatabaseReference myref = database.getReference("Smartphone");
                    myref.setValue(0);
                }
            }
        });

        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lamp.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("LampuAlfian");
                    myref.setValue(1);
                } else {
                    DatabaseReference myref = database.getReference("LampuAlfian");
                    myref.setValue(0);
                }
            }
        });
    }
}