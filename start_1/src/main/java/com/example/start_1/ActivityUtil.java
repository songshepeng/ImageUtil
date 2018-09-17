package com.example.start_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2018/9/11.
 */

public class ActivityUtil {
    public static List<Activity> mActivityList = new ArrayList<>();

     public static void addActivity(Activity activity){
         mActivityList.add(activity);
     }

     public static void removeActivitr(Activity activity){
         mActivityList.remove(activity);
     }

     public static void goToActivity(Context context,Class<?> tClass){
         Intent intent = new Intent(context, tClass);
         context.startActivity(intent);
     }

     public  static void toast(Context context,String connet){
         Toast.makeText(context,connet,Toast.LENGTH_SHORT).show();
     }
     public static void loge(String tag, String connet){
         Log.e(tag, "loge: "+connet);
     }
     public static void finshall(){
         for (Activity activity:mActivityList){

               if (!activity.isFinishing()){

                   activity.finish();
               }
         }
     }
}
