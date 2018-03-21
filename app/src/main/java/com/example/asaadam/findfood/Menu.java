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
     ArrayList bahan;


    //Set Constructor
    public Menu(){}

    public Menu (String judul, String desc,String time,int image) {

        this.judul=judul;
        this.desc=desc;
        this.time=time;
        this.image=image;
    }

    //Getter

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

    public void setBahan(ArrayList bahan) {
        this.bahan = bahan;
    }

    public ArrayList getBahan() {
        return bahan;
    }
}