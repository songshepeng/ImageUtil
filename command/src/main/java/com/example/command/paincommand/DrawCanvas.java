package com.example.command.paincommand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by baidu on 2018/10/10.
 */

public class DrawCanvas extends SurfaceView implements SurfaceHolder.Callback{
    //标识 是否可以绘制，绘制线程是否可以运行
    public boolean isDrwing,isRunning;
    private Bitmap mBitmap ;// 绘制到的位图对象
    private  DrawInvoker mDrawInvoker ; //绘制命令请求对象
    private  DrawThread  drawThread;  //绘制线程


    public DrawCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDrawInvoker = new DrawInvoker();
        drawThread  = new DrawThread();
        getHolder().addCallback(this);
    }

    /**
     *增添一条绘制路劲
     *
     */

  public void  add(DrawPath drawPath){
      mDrawInvoker.add(drawPath);
  }

    /**
     *重做上一次的绘制
     *
     */

  public void redo(){
      isDrwing = true;
      mDrawInvoker.redo();
  }
    /**
     * 撤销上一步绘制
     *
     */

  public void undo(){
      isDrwing = true;
      mDrawInvoker.updo();
  }

    /**
     *是否可以重绘
     *
     */

  public boolean canRedo(){
      return  mDrawInvoker.canRedo();
  }
    /**
     * 是否可以撤销
     *
     */

  public  boolean canUndo(){
      return mDrawInvoker.canUndo();
  }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRunning = true;
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
         mBitmap =  Bitmap.createBitmap(width,height, Bitmap.Config.RGB_565);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true ;
        isRunning =false;
        while (retry){
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private class DrawThread extends Thread{

        @Override
        public void run() {
            Canvas canvas = null ;
            while (isRunning){
                if (isDrwing){
                    try {


                        canvas = getHolder().lockCanvas(null);
                        if (mBitmap == null) {
                            mBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        }
                        Canvas c = new Canvas(mBitmap);
                        c.drawColor(0, PorterDuff.Mode.CLEAR);
                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        mDrawInvoker.execute(c);
                        canvas.drawBitmap(mBitmap, 0, 0, null);
                    } finally {
                        getHolder().unlockCanvasAndPost(canvas);
                    }
                    isDrwing = false;
                }
            }
        }
    }
}
