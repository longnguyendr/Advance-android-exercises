package com.example.lab3_1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.sql.Time;

public class CountDownActivity extends AppCompatActivity {
    TextView txtTime;
    int TimeVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        txtTime = findViewById(R.id.TimeDisplay);
        Intent i = getIntent();
        TimeVal = i.getIntExtra("TimeVal",0);


    }

    @Override
    protected void onStart() {
        super.onStart();
        countTime(TimeVal);
    }

    void countTime (int TimeVal) {
        new CountDownTimer( (TimeVal+1)*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                txtTime.setText("Time: " +millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                txtTime.setText("done!");
            }
        }.start();
    }
}
