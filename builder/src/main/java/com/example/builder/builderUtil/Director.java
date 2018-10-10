package com.example.builder.builderUtil;

/**
 * Created by baidu on 2018/9/25.
 */

public class Director {

    Builder mBuilder = null ;

    public Director(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }


    public void computers(String board, String dislay){
        mBuilder.builderBord(board);
        mBuilder.builderDisplay(dislay);
        mBuilder.builderOS();
    }
}
