package com.example.asaadam.findfood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

/**
 * Created by asaadam on 1/11/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<Menu> menus;
    private Context context;
    public MenuAdapter(Context context, ArrayList<Menu> menus) {
        this.context=context;
        this.menus=menus;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context)
                .inflate(R.layout.list_item,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Menu currentWord = menus.get(position);
        holder.desc.setText(currentWord.getDesc());
        holder.image.setImageResource(currentWord.getImage());
        holder.judul.setText(currentWord.getJudul());
        holder.time.setText(currentWord.getTime());
    }

    @Override
    public int getItemCount() {
        return this.menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView desc;
        private TextView judul;
        private TextView time;
        private ImageView image;

    public ViewHolder(@NonNull View view) {
        super(view);
        desc = (TextView) view.findViewById(R.id.desc);
        judul = (TextView) view.findViewById(R.id.judul);
        time = (TextView) view.findViewById(R.id.time);
        image = (ImageView) view.findViewById(R.id.imageMakanan);
    }
    }


}