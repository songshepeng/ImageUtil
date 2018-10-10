package com.example.builder.builderUtil;

/**
 * Created by baidu on 2018/9/25.
 */

public class MacBuilder extends Builder {

    private Computer computer =new MacBook();
    @Override
    public void builderBord(String board) {
        computer.setmBoard(board);
    }

    @Override
    public void builderDisplay(String display) {
        computer.setmDisplay(display);
    }

    @Override
    public void builderOS() {
        computer.setmOs();
    }

    @Override
    public Computer computer() {
        return computer;
    }
}
