package com.example.asaadam.findfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by asaadam on 3/14/2018.
 */

public class MenuList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);


        SpecialHariIni menus = new SpecialHariIni();
        SpecialBulanIni mSpecialBulanIni = new SpecialBulanIni();
        Following following = new Following();

        //Set Adapter
        MenuAdapter adapter = new MenuAdapter(this, menus.initData());
        MenuAdapter adapter2 = new MenuAdapter(this, mSpecialBulanIni.initData());
        MenuAdapter adapter3 = new MenuAdapter(this,following.initData());

        //Find List View
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.list1);
        RecyclerView recyclerView3 = (RecyclerView)findViewById(R.id.list2);
        //Set Adapter to list View
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView3.setAdapter(adapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
}