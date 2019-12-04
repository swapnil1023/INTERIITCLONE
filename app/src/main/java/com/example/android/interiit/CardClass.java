package com.example.android.interiit;

public class CardClass {

    private String mT1;
    private String mT2;
    private int l1;
    private int l2;
    public CardClass(int Logo1,String Team1,int Logo2,String Team2) {
        mT1=Team1;
        mT2=Team2;
        l1=Logo1;
        l2=Logo2;
    }
    public String getTeam1(){
        return mT1;
    }
    public String getTeam2(){
        return mT2;
    }
    public int getLogo1(){
        return l1;
    }
    public int getLogo2(){
        return l2;
    }
}
