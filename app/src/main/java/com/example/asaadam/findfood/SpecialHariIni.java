package com.example.asaadam.findfood;

import java.util.ArrayList;

/**
 * Created by asaadam on 16/03/18.
 */

public class SpecialHariIni {
    public ArrayList<Menu> initData(){
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu("Nasi Goreng", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi Ayam", "Testing", "20",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi Goreng", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi asdasd", "asdsadasd dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi asdasdasd", "asdasdasdasd dibuat ", "30",R.drawable.ic_launcher_foreground));




        return menus;
    }
}
