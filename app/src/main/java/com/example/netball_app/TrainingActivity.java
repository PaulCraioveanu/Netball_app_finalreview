package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TrainingActivity extends AppCompatActivity {
    TextView tvbeginnerdrill, tvintermediatedrill, tvadvanceddrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        //assigned button and click listener - new activity
        tvbeginnerdrill = findViewById(R.id.tvbeginnerdrill);
        tvbeginnerdrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingActivity.this, BeginnerDrillActivity.class);
                startActivity(intent);
            }
        });
        //assigned button and click listener - new activity
        tvintermediatedrill = findViewById(R.id.tvintermediatedrill);
        tvintermediatedrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingActivity.this, IntermediateDrillActivity.class);
                startActivity(intent);
            }
        });
        //assigned button and click listener - new activity
        tvadvanceddrill = findViewById(R.id.tvadvanceddrill);
        tvadvanceddrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingActivity.this, AdvancedDrillActivity.class);
                startActivity(intent);
            }
        });
    }
}