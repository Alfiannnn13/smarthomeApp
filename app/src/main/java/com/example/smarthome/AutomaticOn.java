package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class AutomaticOn extends AppCompatActivity {

    private TextView terrace, livingroom, alfianroom, backbedroom;


    private int selectedTabNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic_on);

        terrace = findViewById(R.id.tab_terrace);
        livingroom = findViewById(R.id.tab_livingroom);
        alfianroom = findViewById(R.id.tab_alfianroom);
        backbedroom = findViewById(R.id.tab_backbedroom);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentcontainer, FragmentTerrace.class, null)
                        .commit();

        terrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(1);
            }
        });

        livingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(2);
            }
        });

        alfianroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(3);
            }
        });

        backbedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(4);
            }
        });
    }

    private void selectTab(int tabNumber){

        TextView selectedTextView;

        TextView nonSelectedTextView1;
        TextView nonSelectedTextView2;
        TextView nonSelectedTextView3;

        if(tabNumber == 1){
            selectedTextView = terrace;

            nonSelectedTextView1 = livingroom;
            nonSelectedTextView2 = alfianroom;
            nonSelectedTextView3 = backbedroom;

            //set fragment
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentcontainer, FragmentTerrace.class, null)
                    .commit();

        }
        else if (tabNumber == 2) {
            selectedTextView = livingroom;

            nonSelectedTextView1 = terrace;
            nonSelectedTextView2 = alfianroom;
            nonSelectedTextView3 = backbedroom;

            //set fragment
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentcontainer, FragmentLivingRoom.class, null)
                    .commit();
        }
        else if (tabNumber == 3) {
            selectedTextView = alfianroom;

            nonSelectedTextView1 = terrace;
            nonSelectedTextView2 = livingroom;
            nonSelectedTextView3 = backbedroom;

            //set fragment
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentcontainer, FragmentAlfianRoom.class, null)
                    .commit();
        }
        else {
            selectedTextView = backbedroom;

            nonSelectedTextView1 = terrace;
            nonSelectedTextView2 = livingroom;
            nonSelectedTextView3 = alfianroom;

            //set fragment
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentcontainer, FragmentBackBedroom.class, null)
                    .commit();
        }

        float slideTo = (tabNumber - selectedTabNumber) * selectedTextView.getWidth();

        TranslateAnimation translateAnimation = new TranslateAnimation(0, slideTo,0,0);

        translateAnimation.setDuration(300);

        if(selectedTabNumber == 1) {
            terrace.startAnimation(translateAnimation);
        }
        else if (selectedTabNumber == 2) {
            livingroom.startAnimation(translateAnimation);
        }
        else if (selectedTabNumber == 3) {
            alfianroom.startAnimation(translateAnimation);
        }
        else {
            backbedroom.startAnimation(translateAnimation);
        }

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                selectedTextView.setBackgroundResource(R.drawable.round_back2);
                selectedTextView.setTypeface(null, Typeface.BOLD);
                selectedTextView.setTextColor(Color.BLACK);


                nonSelectedTextView1.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedTextView1.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedTextView1.setTypeface(null,Typeface.NORMAL);

                nonSelectedTextView2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedTextView2.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedTextView2.setTypeface(null,Typeface.NORMAL);

                nonSelectedTextView3.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonSelectedTextView3.setTextColor(Color.parseColor("#80FFFFFF"));
                nonSelectedTextView3.setTypeface(null,Typeface.NORMAL);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        selectedTabNumber = tabNumber;
    }
}