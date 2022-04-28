package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.net.InetSocketAddress;

//buttons declared
public class ResourcesActivity extends AppCompatActivity {
    private ImageButton ibGuide, ibExercises, ibPositions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        //find specific button and set what it does on click - move to another activity
        ibGuide = findViewById(R.id.ibGuide);
        ibGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this, GuideActivity.class);
                startActivity(intent);
            }
        });
        //find specific button and set what it does on click - move to another activity
        ibExercises = findViewById(R.id.ibExercises);
        ibExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this, ExercisesActivity.class);
                startActivity(intent);
            }
        });

        //find specific button and set what it does on click - move to another activity
        ibPositions = findViewById(R.id.ibPositions);
        ibPositions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this,PostionActivity.class);
                startActivity(intent);
            }
        });


    }

}