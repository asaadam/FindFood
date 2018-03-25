package com.example.asaadam.findfood;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;

/**
 * Created by asaadam on 16/03/18.
 */

public class SpecialHariIni {
    public ArrayList<Menu> initData(){
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu("Nasi Goreng", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi Goreng2", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi Goreng3", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
       Menu test= menus.get(2);
      test.setBahan("Sayur",30);
      test.setBahan("Kecap",30);



        return menus;
    }
}

