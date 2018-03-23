package com.example.asaadam.findfood;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by asaadam on 16/03/18.
 */

public class SpecialHariIni {
    public ArrayList<Menu> initData(){
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu("Nasi Goreng", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
       Menu test= menus.get(0);
      test.setBahan("Sayur",30);
      test.setBahan("Kecap",30);



        return menus;
    }
}
