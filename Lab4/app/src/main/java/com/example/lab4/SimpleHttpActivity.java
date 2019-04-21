package com.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SimpleHttpActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView ResDisplay;
    private Button btnSend;
    private EditText URLInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_http);
        btnSend = findViewById(R.id.URL_button);
        btnSend.setOnClickListener(this);
        URLInput = findViewById(R.id.URL_input);
        ResDisplay = findViewById(R.id.Response_Display);
        ResDisplay.setMovementMethod(new ScrollingMovementMethod());

    }

    @Override
    public void onClick(View view) {
        String url;
        url = URLInput.getText().toString();
        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, CheckValid(url),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ResDisplay.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ResDisplay.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }

    protected String CheckValid (String url){
        if (!url.contains("https://")) {
            url = "https://" + url;
        }
        return url;
    }

}
