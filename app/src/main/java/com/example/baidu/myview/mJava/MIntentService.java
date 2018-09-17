package com.example.baidu.myview.mJava;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by baidu on 2018/9/4.
 */

public class MIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    private static final String TAG = MIntentService.class.getCanonicalName();
    public MIntentService(String name) {
        super(name);
    }

    public MIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getStringExtra("task_action");
        Log.d(TAG, "onHandleIntent: "+action);
        SystemClock.sleep(3000);
        if ("is".equals(action)){
            Log.d(TAG, "onHandleIntent: "+action);
        }
    }

    @Override
    public void onDestroy() {

        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
