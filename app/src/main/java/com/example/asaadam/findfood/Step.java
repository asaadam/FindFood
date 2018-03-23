package com.example.asaadam.findfood;

import org.parceler.Parcel;

/**
 * Created by asaadam on 3/23/2018.
 */
@Parcel
public class Step {
     String step;
     int time;


public Step(){

}

public Step (String step,int time){
    this.step=step;
    this.time=time;
}

    public int getTime() {
        return time;
    }

    public String getStep() {
        return step;
    }

}
