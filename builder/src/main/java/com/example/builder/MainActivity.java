package com.example.builder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.builder.builderUtil.Builder;
import com.example.builder.builderUtil.Director;
import com.example.builder.builderUtil.MacBuilder;
import com.example.builder.cloneUtil.WrodeDument;
import com.example.builder.factoryUtil.AudiCarFactory;
import com.example.builder.factoryUtil.AudiFactory;
import com.example.builder.factoryUtil.AudiQ1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Builder macBuilder = new MacBuilder();
        Director director = new Director(macBuilder);
        director.computers("英特尔主板","Reting 显示器");

        Log.e("MainActivity", "onCreate: "+macBuilder.computer().toString() );


        WrodeDument wrodeDument = new WrodeDument();
        wrodeDument.setmText("这是一份惊喜");
        wrodeDument.addImages("惊喜1");
        wrodeDument.addImages("惊喜2");
        wrodeDument.addImages("惊喜3");
        wrodeDument.show();
        WrodeDument clone = wrodeDument.clone();
        clone.show();
        clone.setmText("这不是惊喜了 ");
        clone.show();


        AudiCarFactory audiCarFactory = new AudiCarFactory();
        AudiQ1 audiQ1 = audiCarFactory.createAudiFactory(AudiQ1.class);
        audiQ1.drive();
        audiQ1.selfNavigation();
    }
}
