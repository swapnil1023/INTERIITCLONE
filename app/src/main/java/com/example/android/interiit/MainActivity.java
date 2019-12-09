package com.example.android.interiit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CardView Volleyball=findViewById(R.id.Volleyball);
        final CardView Badminton=findViewById(R.id.Badminton);
        final CardView Squash=findViewById(R.id.Squash);
        final CardView TableTennis=findViewById(R.id.TableTennis);

        Volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Volleyball.class);
                startActivity(intent);
            }
        });

        Badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Badminton.class);
                startActivity(intent);
            }
        });
        Squash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Squash.class);
                startActivity(intent);
            }
        });
        TableTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TableTennis.class);
                startActivity(intent);
            }
        });


    }
}
