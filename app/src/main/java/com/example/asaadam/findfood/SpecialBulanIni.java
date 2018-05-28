package com.example.asaadam.findfood;

import java.util.ArrayList;


/**
 * Created by asaadam on 15/03/18.
 */

public class SpecialBulanIni {
    public ArrayList<Menu> initData(){
        ArrayList<Menu> result = new ArrayList<>();
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        result.add(new Menu("Mie Goreng ", "Mie Goreng sehat lebih sehat dari indomie ", "30",R.drawable.chinese));
        Menu test= result.get(0);
        test.setBahan("asdasd",1);
        test.setBahan("asdasdasd",2);
        test.setBahan("asdasdasd",3);
        test.setBahan("asdasdasda",3);
        test.setBahan("asdasdasdasd",5);
        test.setBahan("asdasdasdasda",1);
        test.setBahan("asdasdasdasda",10);
        test.setBahan("asdasdasdasda",2);
        test.setBahan("asdasdasdasda",1);
        test.setSteps("asdasdasdasda.\n" +
                "\n",30,R.drawable.daging2);
        test.setSteps("Iris2. Bagi 2 air kaldunya.",60,R.drawable.daging3);
        test.setSteps("asdasdasdasda.\n" +
                "\n",10,R.drawable.daging4);
        test.setSteps("asdasdasdasda\n" +
                "\n",5,R.drawable.daging5);
        test.setSteps("asdasdasdasda\n" +
                "\n",2,R.drawable.daging6);
        test.setSteps("Tumbuk kentang & telur, masukkan air kaldu, susu, dan bumbu. " +
                "\n",3,R.drawable.daging7);
        test.setSteps("Masak hingga kuah menyusut. Di tahap ini kalau ingin kuah/sausnya halus, angkat lidahnya, blender kuahnya.\n" +
                "\n",5,R.drawable.daging8);
        test.setSteps("Masak hingga kentang mengental.\n" +
                "\n" +
                "\n",1,R.drawable.daging9);
        test.setSteps("Plating Beef Steak & kentang di piring. hidangkan.\n" +
                "\n" +
                "\n",0,R.drawable.daging1);


        return result;
    }
}
