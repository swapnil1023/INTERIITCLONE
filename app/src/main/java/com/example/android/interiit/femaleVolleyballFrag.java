package com.example.android.interiit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class femaleVolleyballFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.activity_male_frag, container, false);

        ArrayList<CardClass> list=new ArrayList<>() ;
        list.add(new CardClass(R.drawable.madras,"IIT Female",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Masdja",R.drawable.indore,"IIT MAdr" ));
        list.add(new CardClass(R.drawable.madras,"IIT Mad",R.drawable.indore,"IIT M" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));

        final int [] cursor=new int[20];
        listArrayAdapter adapter=new listArrayAdapter(getActivity(),0,list);
        ListView lv=rootView.findViewById(R.id.Schedule);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView score=view.findViewById(R.id.score);
                if(cursor[i]==0 ){
                    cursor[i]=1;
                    expand(view,250,0);
                    score.setVisibility(View.VISIBLE);
                    score.setText("0-0");

                }
                else{
                    cursor[i]=0;
                    collapse(view,250,0);
                }
            }
        });
        return rootView;
    }

    public static void expand(final View v, int duration, int targetHeight) {

        int prevHeight  = v.getHeight();

        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, 2*prevHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }



    public static void collapse(final View v, int duration, int targetHeight) {
        int prevHeight  = v.getHeight();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, prevHeight/2);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }

}
