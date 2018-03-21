package com.example.asaadam.findfood;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcel;
import org.parceler.Parcels;

public class Menu_Page_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__page_1);
        Menu menu = (Menu) Parcels.unwrap(getIntent().getParcelableExtra("menu"));
        TextView tvJudul = findViewById(R.id.tvJudul);
        tvJudul.setText(menu.getJudul());
        ImageView ivJudul=findViewById(R.id.imageMakanan1);
        ivJudul.setImageResource(menu.getImage());

        BahanAdapter bahan1 = new BahanAdapter(this,menu);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.rv1);
        recyclerView.setAdapter(bahan1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }



}

