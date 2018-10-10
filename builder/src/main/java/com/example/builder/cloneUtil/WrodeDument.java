package com.example.builder.cloneUtil;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by baidu on 2018/9/25.
 */

public class WrodeDument implements Cloneable {

    private  String mText;
    private ArrayList<String>mImags = new ArrayList<>();

    public WrodeDument() {
        Log.e("WrodeDument", "WrodeDument: + 构造函数 +" );
    }
   @Override
    public WrodeDument  clone(){
       try {
           WrodeDument doc = (WrodeDument) super.clone();
           doc.mText = this.mText;
           doc.mImags = this.mImags;
           return  doc;
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
       }

       return  null;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public ArrayList<String> getmImags() {
        return mImags;
    }

    public void setmImags(ArrayList<String> mImags) {
        this.mImags = mImags;
    }

    public void  addImages(String img){
       this.mImags.add(img);
    }

    public void show(){
        Log.e("WrodeDument", "show: "+this.toString() );

    }

    @Override
    public String toString() {
        return "WrodeDument{" +
                "mText='" + mText + '\'' +
                ", mImags=" + mImags +
                '}';
    }
}
