package com.example.command.paincommand;

import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by baidu on 2018/10/10.
 */

public interface Ibrush {
    /**
     *触点接触时
     * @param path 路劲对象
     * @param x 当前位置x的坐标
     *@param y  当前位置y的坐标
     */

    void down(Path path,float x , float y);
    /**
     *触点移动时
     *@param path 路劲对象
     * @param x 当前位置x的坐标
     *@param y  当前位置y的坐标
     */

    void move(Path path,float x , float y);


    /**
     *触点离开时
     *@param path 路劲对象
     * @param x 当前位置x的坐标
     *@param y  当前位置y的坐标
     */
    void up(Path path,float x,float y);
}
