package com.example.asaadam.findfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by asaadam on 3/14/2018.
 */

public class MenuList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        //Create Arraylist for menus.
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu("Nasi Goreng", "Mudah dibuat ", "30",R.drawable.testimage));
        menus.add(new Menu("Nasi Ayam", "Testing", "20",R.drawable.testimage));

        //Set Adapter
        MenuAdapter adapter = new MenuAdapter(this, menus);

        //Find List View
        ListView listView = (ListView) findViewById(R.id.list);
        //Set Adapter to list View
        listView.setAdapter(adapter);
    }
}