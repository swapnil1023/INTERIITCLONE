package com.example.android.interiit;

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
                    score.setVisibility(View.GONE);
                }
            }
        });
        return rootView;
    }
}
