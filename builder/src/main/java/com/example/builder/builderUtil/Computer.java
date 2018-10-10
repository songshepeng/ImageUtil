package com.example.builder.builderUtil;

/**
 * Created by baidu on 2018/9/25.
 */

public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    protected Computer() {

    }

    public void setmBoard(String mBoard) {
        this.mBoard = mBoard;
    }

    public void setmDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
    }

    public abstract void setmOs();

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
