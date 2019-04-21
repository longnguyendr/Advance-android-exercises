package com.example.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button btnStockMonitor, btnStockMonitorV2 , btnSimpleHttp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSimpleHttp = findViewById(R.id.SimpleHttp_button);
        btnSimpleHttp.setOnClickListener(this);
        btnStockMonitor = findViewById(R.id.StockMonitor_button);
        btnStockMonitor.setOnClickListener(this);
        btnStockMonitorV2 = findViewById(R.id.StockMonitorV2_button);
        btnStockMonitorV2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SimpleHttp_button:
                startActivity(new Intent(MainActivity.this, SimpleHttpActivity.class));
                break;
            case R.id.StockMonitor_button:
                startActivity(new Intent(MainActivity.this, StockMonitorActivity.class));
                break;
            case R.id.StockMonitorV2_button:
                startActivity(new Intent(MainActivity.this, StockMonitorV2Activity.class));
                break;
                default: break;
        }
    }
}



