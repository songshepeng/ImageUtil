package com.example.command;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.command.commandutil.BottomCommand;
import com.example.command.commandutil.Buttons;
import com.example.command.commandutil.LeftCommand;
import com.example.command.commandutil.RightCommand;
import com.example.command.commandutil.TetrisMachine;
import com.example.command.commandutil.TransFromCommand;
import com.example.command.paincommand.CircleBrush;
import com.example.command.paincommand.DrawCanvas;
import com.example.command.paincommand.DrawPath;
import com.example.command.paincommand.Ibrush;
import com.example.command.paincommand.NormalBrush;

public class MainActivity extends AppCompatActivity {
 private DrawCanvas mDrawCanvas ;
 private DrawPath  mDrawPath ;
 private Paint mPaint;
 private Ibrush mIbrush;
 private Button undo,redo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.WHITE);
        mIbrush = new NormalBrush();

        mDrawCanvas = (DrawCanvas) findViewById(R.id.mDrawCanvas);
        mDrawCanvas.setOnTouchListener(new DrawTouchListener());
        undo=(Button) findViewById(R.id.undo);
        undo.setEnabled(false);
        redo=(Button) findViewById(R.id.redo);
        redo.setEnabled(false);

        Button red = (Button) findViewById(R.id.red);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(Color.RED);
            }
        });

        Button circular_paint = (Button) findViewById(R.id.circular_paint);
        circular_paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIbrush = new CircleBrush();

            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.red:
                   mPaint = new Paint();
                   mPaint.setStrokeWidth(3);
                   mPaint.setColor(Color.RED);
                break;
            case R.id.green:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(Color.GREEN);
                break;
            case R.id.blue:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(Color.BLUE);
                break;
            case R.id.undo:
                  mDrawCanvas.undo();
                  if (!mDrawCanvas.canUndo()){
                      undo.setEnabled(false);
                  }
                  undo.setEnabled(true);
                break;
            case R.id.redo:
                mDrawCanvas.redo();
                if (!mDrawCanvas.canRedo()){
                    redo.setEnabled(false);
                }
                redo.setEnabled(true);
                break;
            case R.id.circular_paint:
                mIbrush = new CircleBrush();

            case R.id.ordinary_paint:
                mIbrush = new NormalBrush();
                break;
            default:
                break;
        }
    }

    private class DrawTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction()== MotionEvent.ACTION_DOWN){
                 mDrawPath = new DrawPath();
                mDrawPath.paint = mPaint;
                mDrawPath.path = new Path();
                mIbrush.down(mDrawPath.path,event.getX(),event.getY());
            }else if (event.getAction()==MotionEvent.ACTION_MOVE){
                mIbrush.move(mDrawPath.path,event.getX(),event.getY());
            }else if (event.getAction()==MotionEvent.ACTION_UP){
                mIbrush.up(mDrawPath.path,event.getX(),event.getY());
                mDrawCanvas.add(mDrawPath);
                mDrawCanvas.isDrwing= true;
                undo.setEnabled(true);
                redo.setEnabled(false);
            }

            return true;
        }
    }
}
