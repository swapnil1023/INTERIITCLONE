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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;


public class femaleSquashFrag extends Fragment {
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

        /*Map empMap= new HashMap<>();
        empMap.put("flag","0");
        empMap.put("team1","madras");
        empMap.put("team2","madras");
        empMap.put("s1score1","");
        empMap.put("s1score2","");
        empMap.put("s2score1","");
        empMap.put("s2score2","");
        empMap.put("s3score1","");
        empMap.put("s3score2","");
        empMap.put("s4score1","");
        empMap.put("s4score2","");
        empMap.put("s5score1","");
        empMap.put("s5score2","");
        empMap.put("Day","");
        empMap.put("Time","");
        empMap.put("Court","");

        DocumentReference ref = badF.collection("Squash").document("female");

        for(int i=1 ; i<=24; i++)
        {
            empMap.put("MNo",i);
            ref.collection("matches")
                    .document(String.valueOf(i))
                    .set(empMap);
        }*/

        badF.collection("Squash").document("female").collection("matches").orderBy("MNo").addSnapshotListener(new EventListener<QuerySnapshot>() {
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

        final int [] cursor=new int[32];
        /*listArrayAdapter adapter=new listArrayAdapter(getActivity(),0,list);
        lv.setAdapter(adapter);*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Task<DocumentSnapshot> task;
                task = badF.collection("Squash").document("female").collection("matches").document(String.valueOf(i+1)).get();
                while(!task.isComplete());

                DocumentSnapshot ds = task.getResult();


                LinearLayout scoreView1=view.findViewById(R.id.score_view_set1);
                LinearLayout scoreView2=view.findViewById(R.id.score_view_set2);
                LinearLayout scoreView3=view.findViewById(R.id.score_view_set3);
                RelativeLayout location=view.findViewById(R.id.location);
                TextView set1score1=view.findViewById(R.id.score1set1);
                TextView set1score2=view.findViewById(R.id.score2set1);
                TextView set2score1=view.findViewById(R.id.score1set2);
                TextView set2score2=view.findViewById(R.id.score2set2);
                TextView set3score1=view.findViewById(R.id.score1set3);
                TextView set3score2=view.findViewById(R.id.score2set3);
                TextView set4score1=view.findViewById(R.id.score1set4);
                TextView set4score2=view.findViewById(R.id.score2set4);
                TextView set5score1=view.findViewById(R.id.score1set5);
                TextView set5score2=view.findViewById(R.id.score2set5);
                TextView court=view.findViewById(R.id.court);
                TextView day=view.findViewById(R.id.day);
                TextView time=view.findViewById(R.id.time);
                TextView status=view.findViewById(R.id.match_status);
                if(cursor[i]==0 ){
                    cursor[i]=1;
                    location.setVisibility(View.VISIBLE);
                    court.setText("Court No." + ds.get("Court").toString());
                    day.setText("Day " + ds.get("Day").toString());
                    time.setText(ds.get("Time").toString());
                    if(ds.get("flag").toString().equals("0")){
                        status.setVisibility(View.VISIBLE);

                    }
                    else {
                        status.setVisibility(View.GONE);
                        scoreView1.setVisibility(View.VISIBLE);
                        location.setVisibility(View.VISIBLE);
                        if(!ds.get("s2score1").toString().equals(""))
                            scoreView2.setVisibility(View.VISIBLE);
                        if(!ds.get("s3score1").toString().equals(""))
                            scoreView3.setVisibility(View.VISIBLE);
                        if(!ds.get("s4score1").toString().equals(""))
                            scoreView3.setVisibility(View.VISIBLE);
                        if(!ds.get("s5score1").toString().equals(""))
                            scoreView3.setVisibility(View.VISIBLE);
                        set1score1.setText(ds.get("s1score1").toString());
                        set1score2.setText(ds.get("s1score2").toString());
                        set2score1.setText(ds.get("s2score1").toString());
                        set2score2.setText(ds.get("s2score2").toString());
                        set3score1.setText(ds.get("s3score1").toString());
                        set3score2.setText(ds.get("s3score2").toString());
                        set4score1.setText(ds.get("s4score1").toString());
                        set4score2.setText(ds.get("s4score2").toString());
                        set5score1.setText(ds.get("s5score1").toString());
                        set5score2.setText(ds.get("s5score2").toString());
                    }
                }
                else{
                    cursor[i]=0;
                    location.setVisibility(View.GONE);
                    status.setVisibility(View.GONE);
                    scoreView1.setVisibility(View.GONE);

                }
            }
        });
        return rootView;
    }


}
