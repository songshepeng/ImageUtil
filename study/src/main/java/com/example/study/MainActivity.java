package com.example.study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import imageutil.DiskCache;
import imageutil.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView mimg;
    private String mUrl ="http://img.zcool.cn/community/0117e2571b8b246ac72538120dd8a4.jpg@1280w_1l_2o_100sh.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mimg = (ImageView) findViewById(R.id.mimg);
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.setType(new DiskCache());
        imageLoader.displayImageView(mUrl,mimg);
    }
}
