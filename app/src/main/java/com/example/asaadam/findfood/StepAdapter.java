package com.example.asaadam.findfood;

import android.content.Context;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asaadam on 3/23/2018.
 */

public class StepAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<Step> steps;

    public StepAdapter (Context context,ArrayList<Step> step){
        this.steps=step;
        this.context=context;
    }



    @Override
    public int getCount() {
        return this.steps.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

       final Step currentStep = steps.get(position);

       View view = layoutInflater.inflate(R.layout.step_slide,container,false);

        TextView startText = (TextView)view.findViewById(R.id.startTimer);
        final TextView timer = (TextView)view.findViewById(R.id.textClock);
        TextView step = (TextView)view.findViewById(R.id.stepTv);
        ImageView imageView=(ImageView)view.findViewById(R.id.stepImage);

        String timerText=Integer.toString(currentStep.getTime());
        timer.setText(timerText);
        step.setText(currentStep.getStep());
        imageView.setImageResource(currentStep.getImage());
        startText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int second = currentStep.getTime();
                CountDownTimer countDownTimer = new CountDownTimer(second*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                       String count=Long.toString(millisUntilFinished/1000);
                        timer.setText(count);
                    }
                    @Override
                    public void onFinish() {
                        timer.setText("FINISH");

                    }
                }.start();
            }
        });
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);



    }
}
