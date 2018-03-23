package com.example.asaadam.findfood;

/**
 * Created by asaadam on 3/23/2018.
 */

public class Step {
    private String step;
    private int image;

    
public Step (String step,int image){
    this.step=step;
    this.image=image;
}

    public void setImage(int image) {
        this.image = image;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public int getImage() {
        return image;
    }

    public String getStep() {
        return step;
    }

}
