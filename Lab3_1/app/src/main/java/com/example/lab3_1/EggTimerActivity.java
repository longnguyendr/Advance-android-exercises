package com.example.lab3_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EggTimerActivity extends AppCompatActivity {
    EditText TimeInput;
    Button btnTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_timer);

        btnTime = findViewById(R.id.TimeButton);
        TimeInput = findViewById(R.id.TimeInput);


        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EggTimerActivity.this, CountDownActivity.class);
                i.putExtra("TimeVal" , Integer.parseInt(String.valueOf(TimeInput.getText())));
                startActivity(i);
            }
        });
    }
}
