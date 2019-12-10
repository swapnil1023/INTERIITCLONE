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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class femaleVolleyballFrag extends Fragment {

    ListView lv;
    listArrayAdapter adapter;
    logoMap logo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.activity_fragment_list, container, false);

        logo = new logoMap();
        final Map logoM = logo.getMap();

        //Female Volleyball Schedule
        lv=rootView.findViewById(R.id.Schedule);
        final FirebaseFirestore badF;
        badF = FirebaseFirestore.getInstance();
        final ArrayList<CardClass> list=new ArrayList<>() ;
        /*list.add(new CardClass(R.drawable.madras ,"IIT Female VOLLEY",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Masdja",R.drawable.indore,"IIT MAdr" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Mad",R.drawable.indore,"IIT M" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));
        list.add(new CardClass(R.drawable.madras ,"IIT Madras",R.drawable.indore,"IIT Indore" ));*/

       /* Map empMap= new HashMap<>();
        empMap.put("team1","madras");
        empMap.put("team2","madras");
        empMap.put("score1","");
        empMap.put("score2","");
        empMap.put("Day","");
        empMap.put("Time","");
        empMap.put("Court","");

        DocumentReference ref = badF.collection("VollyBall").document("female");

        for(int i=1 ; i<=32; i++)
        {
            empMap.put("MNo",i);
            ref.collection("matches")
                    .document(String.valueOf(i))
                    .set(empMap);
        }*/

        badF.collection("VollyBall").document("female").collection("matches").orderBy("MNo").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e)
            {
                if(e!=null)
                {
                    // Toast.makeText(Volleyball.this,"some exception",Toast.LENGTH_SHORT).show();
                }
                for(DocumentChange match: queryDocumentSnapshots.getDocumentChanges())
                {
                    if(match.getType() == DocumentChange.Type.ADDED)
                    {
                        int uri1 = (int) logoM.get(match.getDocument().get("team1"));
                        int uri2 = (int) logoM.get(match.getDocument().get("team2"));
                        list.add(new CardClass(Integer.parseInt(match.getDocument().getId()),uri1,match.getDocument().get("team1").toString(),uri2,match.getDocument().get("team2").toString() ));
                    }
                    adapter=new listArrayAdapter(getActivity(),0,list);
                    lv.setAdapter(adapter);

                }
            }
        });

        final int [] cursor=new int[20];
        /*listArrayAdapter adapter=new listArrayAdapter(getActivity(),0,list);
        lv.setAdapter(adapter);*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
