package com.example.android.interiit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CardView Volleyball=findViewById(R.id.Volleyball);
        CardView Badminton=findViewById(R.id.Badminton);

        Volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Volleyball.class);
                startActivity(intent);
                sport=1;
            }
        });

    }
    public int sport;
}
