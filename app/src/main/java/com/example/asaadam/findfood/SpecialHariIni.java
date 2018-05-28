package com.example.asaadam.findfood;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by asaadam on 16/03/18.
 */

public class SpecialHariIni {
    public ArrayList<Menu> initData(){
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu("Steak ", "Steak enak bergisi dan sangat mudah dibuat ", "30",R.drawable.daging1));
        menus.add(new Menu("Donat ", "Donat Warna Wanri untuk anak ", "30",R.drawable.donat));

       Menu test= menus.get(0);
      test.setBahan("Sayur",1);
      test.setBahan("Blue Band",2);
      test.setBahan("Bombay Cacah",3);
      test.setBahan("Saus Tomat",3);
      test.setBahan("Kuning Telur",5);
        test.setBahan("Merica Bubuk",1);
        test.setBahan("Kecap Manis",10);
        test.setBahan("Kecap Asin",2);
        test.setBahan("Daigin Lidah Sapi",1);
      test.setSteps("Ambil lidah yg sdh direbus & dikerik kulit luarnya. rebus ulang dengan air 500ml.\n" +
              "\n",30,R.drawable.daging2);
        test.setSteps("Iris2. Bagi 2 air kaldunya.",60,R.drawable.daging3);
        test.setSteps("Panaskan margarin, tumis bawang hingga matang.\n" +
                "\n",10,R.drawable.daging4);
        test.setSteps("Masukkan tomat, masak hingga tomat hancur.\n" +
                "\n",5,R.drawable.daging5);
        test.setSteps("Masukkan lidah & 1/2 kaldu, serta garam, gula, kecap manis, kecap inggris, saus tomat, pala, merica, dan kaldu bubuk.\n" +
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



        return menus;
    }
}
