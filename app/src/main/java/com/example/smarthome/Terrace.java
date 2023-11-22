package com.example.smarthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Terrace extends AppCompatActivity {

    TextView nilai, nilai2, nilai3;

    ImageView lamp, waterpump, extension;

    SwitchCompat Sanyo, Lampu, StopKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrace);

        waterpump = (ImageView) findViewById(R.id.isanyo);
        lamp = (ImageView) findViewById(R.id.lampu);
        extension = (ImageView) findViewById(R.id.stopkontak);

        nilai = (TextView) findViewById(R.id.powersanyo);
        nilai2 = (TextView) findViewById (R.id.powerlampteras);
        nilai3 = (TextView) findViewById(R.id.powerstopkontak);
        
        Sanyo = findViewById(R.id.SwitchSanyo);
        Lampu = findViewById(R.id.SwitchLampu);
        StopKontak = findViewById(R.id.SwitchStopKontak);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference sanyo = database.getReference("Sanyo");
        DatabaseReference lampu = database.getReference("Lampu");
        DatabaseReference stopkontak = database.getReference("Colokan");

        stopkontak.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0){
                    StopKontak.setChecked(false);
                    nilai3.setText("OFF");
                    extension.setImageResource(R.drawable.stopkontak);
                }else {
                    StopKontak.setChecked(true);
                    nilai3.setText("ON");
                    extension.setImageResource(R.drawable.stopkontakon);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        sanyo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message == 0){
                    Sanyo.setChecked(false);
                    nilai.setText("OFF");
                    waterpump.setImageResource(R.drawable.sanyo);
                } else {
                    Sanyo.setChecked(true);
                    nilai.setText("ON");
                    waterpump.setImageResource(R.drawable.sanyoon);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lampu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final long message = snapshot.getValue(long.class);
                if (message== 0){
                    Lampu.setChecked(false);
                    nilai2.setText("OFF");
                    lamp.setImageResource(R.drawable.lamp);
                }else {
                    Lampu.setChecked(true);
                    nilai2.setText("ON");
                    lamp.setImageResource(R.drawable.lampon);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Sanyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Sanyo.isChecked()){
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myref = database.getReference("Sanyo");
                    myref.setValue(1);
                }else {
                    DatabaseReference myref = database.getReference("Sanyo");
                    myref.setValue(0);
                }

            }
        });

        Lampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Lampu.isChecked()){
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference ref = database.getReference("Lampu");
                    ref.setValue(1);
                }else {
                    DatabaseReference ref = database.getReference("Lampu");
                    ref.setValue(0);
                }
            }
        });

        StopKontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StopKontak.isChecked()) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference ref = database.getReference("Colokan");
                    ref.setValue(1);
                }else {
                    DatabaseReference ref = database.getReference("Colokan");
                    ref.setValue(0);
                }
            }
        });

    }
}