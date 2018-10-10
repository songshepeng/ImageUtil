package com.example.command.paincommand;

import android.graphics.Path;

/**
 * Created by baidu on 2018/10/10.
 */

public class CircleBrush implements Ibrush {
    @Override
    public void down(Path path, float x, float y) {

    }

    @Override
    public void move(Path path, float x, float y) {
        path.addCircle(x,y,10,Path.Direction.CW);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
