package com.example.asaadam.findfood;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

/**
 * Created by asaadam on 1/11/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<Menu>  {

//Set Constructro
    public MenuAdapter(Context context, ArrayList<Menu> words) {
        super(context, 0, words);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

    //Get Curret position of menus
        Menu currentWord = getItem(position);

        //Set all of item from menu.
        TextView desc = (TextView) listItemView.findViewById(R.id.desc);
        desc.setText(currentWord.getDesc());

        TextView judul = (TextView) listItemView.findViewById(R.id.judul);
        judul.setText(currentWord.getJudul());

        TextView time = (TextView)listItemView.findViewById(R.id.time);
        time.setText(currentWord.getTime());

        ImageView image = (ImageView) listItemView.findViewById(R.id.imageMakanan);
        image.setImageResource(currentWord.getImage());


        return listItemView;
    }
}