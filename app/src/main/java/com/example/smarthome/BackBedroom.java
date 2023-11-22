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

public class BackBedroom extends AppCompatActivity {

    TextView power1, power2;
    SwitchCompat fan, charger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_bedroom);

        power1 = findViewById(R.id.powerfan);
        power2 = findViewById(R.id.powercharger);

        fan = findViewById(R.id.SwitchFan);
        charger = findViewById(R.id.SwitchCharger);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Fan = database.getReference("Fan");
        DatabaseReference Charger = database.getReference("Charger");

        Fan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0) {
                    fan.setChecked(false);
                    power1.setText("OFF");
                } else {
                    fan.setChecked(true);
                    power1.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Charger.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0) {
                    charger.setChecked(false);
                    power2.setText("OFF");
                } else {
                    charger.setChecked(true);
                    power2.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fan.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("Fan");
                    myref.setValue(1);
                } else {
                    DatabaseReference myref = database.getReference("Fan");
                    myref.setValue(0);
                }
            }
        });

        charger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (charger.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("Charger");
                    myref.setValue(1);
                } else {
                    DatabaseReference myref = database.getReference("Charger");
                    myref.setValue(0);
                }
            }
        });

    }
}