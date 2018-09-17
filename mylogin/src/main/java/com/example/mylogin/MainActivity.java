package com.example.mylogin;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private TextView mText;
    private Spinner mSpinner;
    private ArrayList<String> mList;
    private ArrayAdapter<String> mAdapter;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        initView();
        initData();
        manager.cancel(1);

    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("汽车票");
        mList.add("火车票");
        mList.add("飞机票");
        mList.add("轮船票");
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mList);
        mSpinner.setAdapter(mAdapter);

      mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              String item = mAdapter.getItem(position);
              mText.setText("你选择的是"+item);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.myText);
        mSpinner = (Spinner) findViewById(R.id.mSpinner);
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");

    }
}
