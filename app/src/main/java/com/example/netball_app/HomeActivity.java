package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.net.InetSocketAddress;

//all buttons and containers declared
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private
    ImageButton idBtnLogout, ibResources, ibSchedule, ibQuicktraining, ibDiary;
    UserLocalStore userLocalStore;
    TextView etName, etUsername, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //find text view items in activity
        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        //find and set what button does on click - change activity
        ibResources = findViewById(R.id.ibResources);
        ibResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ResourcesActivity.class);
                startActivity(intent);
            }
        });
        //find and set what button does on click - change activity
        ibQuicktraining = findViewById(R.id.ibQuicktraining);
        ibQuicktraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TrainingActivity.class);
                startActivity(intent);
            }
        });
        //find and set what button does on click - change activity
        ibDiary = findViewById(R.id.ibDiary);
        ibDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DiaryActivity.class);
                startActivity(intent);
            }
        });
        //find and set what button does on click - change activity
        ibSchedule = findViewById(R.id.ibSchedule);
        ibSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });
        //find and set what button does on click - log user out
        idBtnLogout = findViewById(R.id.idBtnLogout);
        idBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //code to show data from user (profile data) on Home Page
        userLocalStore = new UserLocalStore(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        //assigning variables to show data as text
        etName.setText(name);
        etUsername.setText(username);
        etEmail.setText(email);

    }

    @Override
    public void onClick(View view) {

    }
}