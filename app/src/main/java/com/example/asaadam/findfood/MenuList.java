package com.example.asaadam.findfood;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by asaadam on 3/14/2018.
 */

public class MenuList extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        SpecialHariIni menus = new SpecialHariIni();
        SpecialBulanIni menus1=new SpecialBulanIni();

        //Set Adapter
        MenuAdapter adapter = new MenuAdapter(this, menus.initData());
        MenuAdapter adapter1=new MenuAdapter(this,menus1.initData());

        //Find recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        RecyclerView recyclerView1=(RecyclerView)findViewById(R.id.list1);
        //Set Adapter to list View
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        mDrawer=(DrawerLayout)findViewById(R.id.drawerlayout);
        NavigationView mview = (NavigationView)findViewById(R.id.nvView);

        //Find edit text
        editText=(EditText)findViewById(R.id.editText);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
