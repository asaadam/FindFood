package com.example.asaadam.findfood.viewholder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

/**
 * Created by asaadam on 1/11/2018.
 */

import com.example.asaadam.findfood.Menu;
import com.example.asaadam.findfood.Menu_Page_1;
import com.example.asaadam.findfood.R;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>   {

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
    public void onBindViewHolder( ViewHolder holder, int position) {
        final Menu currentMenu = menus.get(position);
        holder.desc.setText(currentMenu.getDesc());
        holder.image.setImageResource(currentMenu.getImage());
        holder.judul.setText(currentMenu.getJudul());
        holder.time.setText(currentMenu.getTime());
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Menu_Page_1.class);
                intent.putExtra("menu", Parcels.wrap(currentMenu));
                context.startActivity(intent);
            }
        });
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
        private View parentView;

    public ViewHolder(@NonNull View view) {
        super(view);
        this.parentView=view;
        desc = (TextView) view.findViewById(R.id.desc);
        judul = (TextView) view.findViewById(R.id.judul);
        time = (TextView) view.findViewById(R.id.time);
        image = (ImageView) view.findViewById(R.id.imageMakanan);
    }
    }


}