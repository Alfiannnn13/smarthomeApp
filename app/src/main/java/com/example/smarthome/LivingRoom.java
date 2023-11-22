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

public class LivingRoom extends AppCompatActivity {

    TextView power1, power2;
    SwitchCompat TV, STB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);

        power1 = (TextView) findViewById(R.id.powertv);
        power2 = (TextView) findViewById(R.id.powerstb);

        TV = findViewById(R.id.SwitchTV);
        STB = findViewById(R.id.SwitchSTB);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tv = database.getReference("TV");
        DatabaseReference stb = database.getReference("STB");

        tv.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0) {
                    TV.setChecked(false);
                    power1.setText("OFF");
                } else {
                    TV.setChecked(true);
                    power1.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        stb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0) {
                    STB.setChecked(false);
                    power2.setText("OFF");
                } else {
                    STB.setChecked(true);
                    power2.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TV.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("TV");
                    myref.setValue(1);
                } else {
                    DatabaseReference myref = database.getReference("TV");
                    myref.setValue(0);
                }
            }
        });

        STB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (STB.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("STB");
                    myref.setValue(1);
                }else {
                    DatabaseReference myref = database.getReference("STB");
                    myref.setValue(0);
                }
            }
        });
    }
}