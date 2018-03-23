package com.example.asaadam.findfood;

import org.parceler.Parcel;

/**
 * Created by asaadam on 3/23/2018.
 */
@Parcel

public class Bahan {

     String namaBahan;
     int banyakBahan;

    public Bahan(){}


    public Bahan (String bahan,int banyakBahan){
        this.namaBahan=bahan;
        this.banyakBahan=banyakBahan;
    }
    public int getBanyakBahan() {
        return banyakBahan;
    }

    public String getNamaBahan() {
        return namaBahan;
    }
}
