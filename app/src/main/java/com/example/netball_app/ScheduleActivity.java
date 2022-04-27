package com.example.netball_app;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScheduleActivity extends AppCompatActivity {


    CalendarView schedule;
    TextView calendarr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        schedule = (CalendarView)
                findViewById(R.id.schedule);
        calendarr = (TextView)
                findViewById(R.id.calendarr);

        schedule
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                calendarr.setText(Date);
                            }
                        });
    }
}