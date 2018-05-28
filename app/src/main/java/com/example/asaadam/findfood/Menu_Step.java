package com.example.asaadam.findfood;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

public class Menu_Step extends AppCompatActivity {

    ViewPager viewPager;
    StepAdapter stepAdapter;
    LinearLayout linearLayout;
    TextView[] textViews;
    ArrayList<Step> step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steplayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        linearLayout=(LinearLayout)findViewById(R.id.dotsLayout);
        final Menu menu = (Menu)Parcels.unwrap(getIntent().getParcelableExtra("menu"));
        step=menu.getSteps();
        stepAdapter=new StepAdapter(this,step);
        viewPager.setAdapter(stepAdapter);
        addDotsIndicator();
        viewPager.addOnPageChangeListener(viewListener);

    }

    public void addDotsIndicator() {
        textViews = new TextView[step.size()];
        for (int i = 0; i < textViews.length; i++) {
            textViews[i] = new TextView(this);
            textViews[i].setText(Html.fromHtml("&#8226"));
            textViews[i].setTextSize(40);
            textViews[i].setTextColor(getResources().getColor(R.color.Transparent));
            linearLayout.addView(textViews[i]);
        }

    }

    public void setColorIndicator (int position){
        if (textViews.length > 0) {
            textViews[position].setTextColor(getResources().getColor(R.color.TransparentWhite));
        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        setColorIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
