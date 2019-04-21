package com.example.lab4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab4.Model.Stock;

import java.util.ArrayList;

public class StockMonitorAdapter extends RecyclerView.Adapter<StockMonitorAdapter.ViewHolder> {

    private ArrayList<Stock> mData;

    public StockMonitorAdapter(ArrayList<Stock> mData) {
        this.mData = mData;
    }
    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCompanyName;
        TextView txtPrice;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCompanyName = itemView.findViewById(R.id.companyName);
            txtPrice = itemView.findViewById(R.id.stockPrice);
            this.view = itemView;
        }

        void onBindStock (Stock stock) {
            txtCompanyName.setText(stock.getName());
            txtPrice.setText(stock.getPrice());
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.stock_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Stock stock = mData.get(i);
        viewHolder.onBindStock(stock);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}
