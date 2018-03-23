package com.example.asaadam.findfood;


import org.parceler.Parcel;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Parcel
public class Menu {

    //Set Attribtue
    String judul;
    String desc;
    int image;
    String time;
    ArrayList<Bahan> bahan1 =new ArrayList<Bahan>() ;



    //Set Constructor
    public Menu() {
    }

    public Menu(String judul, String desc, String time, int image) {

        this.judul = judul;
        this.desc = desc;
        this.time = time;
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }

    public String getJudul() {
        return judul;
    }

    public String getTime() {
        return time;
    }

    public void setBahan(String bahan,int banyak) {
        Bahan bahan2 = new Bahan(bahan,banyak);
        bahan1.add(bahan2);
    }

    public ArrayList<Bahan> getBahan1() {
        return bahan1;
    }

}