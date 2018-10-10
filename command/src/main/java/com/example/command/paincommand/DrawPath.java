package com.example.command.paincommand;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by baidu on 2018/10/10.
 */

public class DrawPath implements IDraw {
    //需要绘制的路劲
    public Path path;
    //绘制画笔
    public Paint paint;

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path,paint);
    }

    @Override
    public void undo() {

    }
}
