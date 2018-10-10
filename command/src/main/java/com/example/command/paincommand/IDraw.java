package com.example.command.paincommand;

import android.graphics.Canvas;

/**
 * Created by baidu on 2018/10/10.
 */

public interface IDraw {
    /**
     * 绘制命令
     *@param canvas 画布对象
     */

    void draw(Canvas canvas);
    /**
     *撤销命令
     *
     */

    void undo();
}
