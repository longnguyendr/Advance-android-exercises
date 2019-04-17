package com.example.lab3_1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnZoo, btnExternalEx, btnEggTimer, btnMenus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenus = findViewById(R.id.Menus);
        btnMenus.setOnClickListener(this);
        btnExternalEx = findViewById(R.id.external_link);
        btnExternalEx.setOnClickListener(this);
        btnEggTimer = findViewById(R.id.EggTimer);
        btnEggTimer.setOnClickListener(this);
        btnZoo = findViewById(R.id.zoo);
        btnZoo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Menus:
                startActivity(new Intent(this, MenusActivity.class));
                break;
            case R.id.EggTimer:
                startActivity(new Intent(this, EggTimerActivity.class));
                break;
            case R.id.external_link:
                startActivity(new Intent(this, ExternalActivity.class));
                break;
            case R.id.zoo:
                startActivity(new Intent(this, ZooActivity.class));
                break;
                default:
                    break;
        }
    }
}
