package com.example.builder.builderUtil;

/**
 * Created by baidu on 2018/9/25.
 */

public abstract class Builder {
    //设置主机
    public abstract void builderBord(String board );
    //设置显示器
    public abstract void builderDisplay(String display );
    //设置系统
    public abstract void builderOS();
    //创建computer
    public abstract Computer computer();

}
