package com.example.command.paincommand;

import android.graphics.Path;

/**
 * Created by baidu on 2018/10/10.
 * 普通笔触
 */

public class NormalBrush implements Ibrush {
    @Override
    public void down(Path path, float x, float y) {
        path.moveTo(x,y);
    }

    @Override
    public void move(Path path, float x, float y) {
        path.lineTo(x,y);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
