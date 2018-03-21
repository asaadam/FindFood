package com.example.asaadam.findfood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asaadam on 3/21/2018.
 */

public class BahanAdapter extends RecyclerView.Adapter<BahanAdapter.ViewHolder> {
    private ArrayList<String> bahan;
    private Context context;

    public BahanAdapter(Context context, Menu menus) {
        this.context = context;
        this.bahan = new ArrayList<String>(menus.getBahan());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.bahan_item, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bahan.setText(bahan.get(position));
    }

    @Override
    public int getItemCount() {
        return bahan.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bahan;
        private TextView jumlah;


        public ViewHolder(@NonNull View view) {
            super(view);
            bahan = (TextView) view.findViewById(R.id.bahan);
            jumlah = (TextView) view.findViewById(R.id.banyakBahan);

        }
    }
}