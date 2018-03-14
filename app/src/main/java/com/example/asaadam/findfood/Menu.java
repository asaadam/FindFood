package com.example.asaadam.findfood;


public class Menu {

    //Set Attribtue
    private String judul;
    private String desc;
    private int image;
    private String time;


    //Set Constructor
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
}