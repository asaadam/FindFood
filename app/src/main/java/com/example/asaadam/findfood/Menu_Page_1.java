package com.example.asaadam.findfood;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;

public class Menu_Page_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__page_1);
       final Menu menu = (Menu) Parcels.unwrap(getIntent().getParcelableExtra("menu"));
        TextView tvJudul = findViewById(R.id.tvJudul);
        tvJudul.setText(menu.getJudul());
        ImageView ivJudul=findViewById(R.id.imageMakanan1);
        ivJudul.setImageResource(menu.getImage());
        Button step = (Button)findViewById(R.id.startStep);
        ArrayList<Bahan> bahan=menu.getBahan1();
        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Page_1.this,Menu_Step.class);
                intent.putExtra("menu",Parcels.wrap(menu));
                startActivity(intent);
            }
        });
        BahanAdapter bahan1 = new BahanAdapter(this,bahan);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.rv1);
        recyclerView.setAdapter(bahan1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

