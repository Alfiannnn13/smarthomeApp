package com.example.smarthome;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;


public class FragmentTerrace extends Fragment {

  CardView waterpump, lamp, skontak;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FragmentTerrace() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentTerrace newInstance(String param1, String param2) {
        FragmentTerrace fragment = new FragmentTerrace();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terrace,container,false);
        waterpump = view.findViewById(R.id.WaterPumpOn);
        lamp = view.findViewById(R.id.Lamp);
        skontak = view.findViewById(R.id.ElectrikSocket);

        waterpump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WaterPumpOn.class);
                startActivity(intent);
            }
        });

        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LampOn.class);
                startActivity(intent);
            }
        });

        skontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ESocketOn.class);
                startActivity(intent);
            }
        });
        return view;
    }
}