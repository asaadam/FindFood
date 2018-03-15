package com.example.asaadam.findfood;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by asaadam on 15/03/18.
 */

public class MenuFragment extends Fragment {

    public MenuFragment (){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container, false);
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu("Nasi Goreng", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi Ayam", "Testing", "20",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi Goreng", "Mudah dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi asdasd", "asdsadasd dibuat ", "30",R.drawable.ic_launcher_foreground));
        menus.add(new Menu("Nasi asdasdasd", "asdasdasdasd dibuat ", "30",R.drawable.ic_launcher_foreground));

        //Set Adapter
        MenuAdapter adapter = new MenuAdapter(getActivity(), menus);

        //Find List View
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        //Set Adapter to list View
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        return rootView;
    }
}
