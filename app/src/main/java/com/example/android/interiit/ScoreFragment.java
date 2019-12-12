package com.example.android.interiit;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ScoreFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_score, container, false);


        final CardView Volleyball=rootView.findViewById(R.id.Volleyball);
        final CardView Badminton=rootView.findViewById(R.id.Badminton);
        final CardView Squash=rootView.findViewById(R.id.Squash);
        final CardView TableTennis=rootView.findViewById(R.id.TableTennis);

        Volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Volleyball.class);
                startActivity(intent);
            }
        });

        Badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Badminton.class);
                startActivity(intent);
            }
        });
        Squash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Squash.class);
                startActivity(intent);
            }
        });
        TableTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),TableTennis.class);
                startActivity(intent);
            }
        });
return rootView;
    }
}
