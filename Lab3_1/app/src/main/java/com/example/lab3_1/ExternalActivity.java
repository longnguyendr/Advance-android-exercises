package com.example.lab3_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExternalActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGo, btnPhoneCall,btnMap;
    private EditText URL_input, Phone_input , Map_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        btnGo = findViewById(R.id.goToURL);
        btnGo.setOnClickListener(this);
        btnPhoneCall = findViewById(R.id.Phone_call);
        btnPhoneCall.setOnClickListener(this);
        btnMap = findViewById(R.id.Open_map);
        btnMap.setOnClickListener(this);
        URL_input = findViewById(R.id.URL_input);
        Phone_input = findViewById(R.id.Phone_input);
        Map_input = findViewById(R.id.Map_input);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goToURL:
                goToURL();
                break;
            case R.id.Phone_call:
                Phone_call();
                break;
            case R.id.Open_map:
                OpenMap();
                break;
                default:
                    break;
        }
    }
    public void OpenMap () {
        Uri location;
        if (Map_input.length() > 0) {
            location = Uri.parse("geo:0,0?q=" + Map_input.getText().toString().trim());
        } else {
            location = Uri.parse("geo:0,0?q=Oamk");
        }
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void goToURL () {
        Uri webPages;

        if (URL_input.length() > 0) {
            if (String.valueOf(URL_input.getText()).contains("http://")) {
                webPages = Uri.parse(String.valueOf(URL_input.getText()).trim());
            } else {
                webPages = Uri.parse("http://" + String.valueOf(URL_input.getText()).trim());
            }
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webPages);
            startActivity(webIntent);
        } else {
            Toast.makeText(this, "Please enter Website URL" ,Toast.LENGTH_LONG).show();
        }
    }
    public void Phone_call () {
        Uri number;
        if(Phone_input != null && Phone_input.length() > 0) {
            number = Uri.parse(String.valueOf(Phone_input.getText()));
        } else {
            number = Uri.parse("tel:020 6110200");
        }
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }
}
