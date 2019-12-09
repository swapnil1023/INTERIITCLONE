package com.example.android.interiit;

import androidx.fragment.app.Fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.interiit.femaleVolleyballFrag.collapse;
import static com.example.android.interiit.femaleVolleyballFrag.expand;

public class maleBadmintonFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.activity_fragment_list, container, false);


        //Male Badminton Schedule
        ArrayList<CardClass> list=new ArrayList<>() ;
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"MALE BAD SCHEe" ));
        list.add(new CardClass(R.drawable.madras,"IIT Males",R.drawable.indore,"IIT MAdr" ));
        list.add(new CardClass(R.drawable.madras,"IIT Mad",R.drawable.indore,"IIT M" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras,"IIT Madras",R.drawable.indore,"IIT Indore" ));

        final int [] cursor=new int[list.size()];
        listArrayAdapter adapter = new listArrayAdapter(getContext(),0,list);
        ListView listView = rootView.findViewById(R.id.Schedule);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LinearLayout scoreView=view.findViewById(R.id.score_view);
                TextView score1=view.findViewById(R.id.score1);
                TextView score2=view.findViewById(R.id.score2);
                if(cursor[i]==0 ){
                    cursor[i]=1;
                    expand(view,250,0);
                    scoreView.setVisibility(View.VISIBLE);
                    score1.setText("0");
                    score2.setText("0");
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
        targetHeight=3*prevHeight;
        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
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
        targetHeight=prevHeight/3;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
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
