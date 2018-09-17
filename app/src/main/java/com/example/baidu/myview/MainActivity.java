package com.example.baidu.myview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.baidu.myview.mJava.MIntentService;
import com.example.baidu.myview.ui.MyView;

public class MainActivity extends AppCompatActivity {
   private ThreadLocal<Boolean> booleanThreadLocal = new ThreadLocal<>();
    HandlerThread handlerThread = new HandlerThread("mHandlerThread1");

    private static final String TAG = MainActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booleanThreadLocal.set(true);
        Log.e(TAG, "onCreate: "+ booleanThreadLocal.get() );
        Button mbut = (Button) findViewById(R.id.mbut);

        mbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service = new Intent(MainActivity.this, MIntentService.class);
                service.putExtra("task_action","is");
                startService(service);
            }
        });




//        new  Thread(new Runnable() {
//         @Override
//         public void run() {
//
//              Looper.prepare();
//             Handler handler = new Handler();
//             booleanThreadLocal.set(false);
//             Log.e(TAG, "run: "+ booleanThreadLocal.get());
//          Looper.loop();
//         }
//     }).start();

    }


    @Override
    protected void onDestroy() {
        handlerThread.quit();
        super.onDestroy();
    }
}
