package com.example.builder.factoryUtil;

import android.util.Log;

/**
 * Created by baidu on 2018/9/27.
 */

public class AudiQ1 extends AudiCar {
    @Override
    public void drive() {
        Log.e("AudiQ1", "drive: "+"启动了" );
    }

    @Override
    public void selfNavigation() {
        Log.e("AudiQ1", "drive: "+"开始导航" );

    }
}
