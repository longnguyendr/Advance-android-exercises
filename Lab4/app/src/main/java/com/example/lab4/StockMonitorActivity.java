package com.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab4.Model.Stock;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StockMonitorActivity extends AppCompatActivity {

    final static String TAG = "-------- StockMonitorActivity---------";
    private ArrayList<Stock> StockArr = new ArrayList<Stock>();
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_monitor);

        StockArr.add(new Stock("Apple","0","AAPL"));
        StockArr.add(new Stock("Google","0","GOOGL"));
        StockArr.add(new Stock("Facebook","0","FB"));
        StockArr.add(new Stock("Nokia","0","NOK"));

        mRecycleView = findViewById(R.id.stock_recycleView);
        // in content do not change the layout size of the RecyclerView
        mRecycleView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);
        // specify an adapter
        mAdapter = new StockMonitorAdapter(StockArr);
        mRecycleView.setAdapter(mAdapter);
        HttpRequest();
    }

    private void HttpRequest () {
        RequestQueue queue = Volley.newRequestQueue(this);
        for (Stock stock : StockArr) {
            Log.d(TAG, "--- HttpRequest: " + String.valueOf(stock.getId()));
            queue.add(request(stock));
        }
    }

    protected JsonObjectRequest request(final Stock stock) {
        String url = "https://financialmodelingprep.com/api/company/price/" + stock.getId() + "?datatype=json";

        JsonObjectRequest JSObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "--- onResponse: " + String.valueOf(response));
                        try {
                            int index = StockArr.indexOf(stock);
                            StockArr.get(index).setPrice(response.getJSONObject(stock.getId()).getString("price"));
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                           e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "That didn't work!", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        return JSObjectRequest;
    }
}
