package com.example.asaadam.findfood.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asaadam.findfood.Bahan;
import com.example.asaadam.findfood.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asaadam on 3/21/2018.
 */

public class BahanAdapter extends RecyclerView.Adapter<BahanAdapter.ViewHolder> {
    private List<Bahan> bahan;
    private Context context;

    public BahanAdapter(Context context, ArrayList<Bahan> bahan) {
        this.context = context;
        this.bahan=bahan;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.bahan_item, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bahan currentBahan = bahan.get(position);
        holder.bahan.setText(currentBahan.getNamaBahan().toString());
        String banyak=Integer.toString(currentBahan.getBanyakBahan());
        holder.jumlah.setText(banyak);

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