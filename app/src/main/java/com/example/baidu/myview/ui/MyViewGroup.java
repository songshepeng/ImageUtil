package com.example.baidu.myview.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by baidu on 2018/8/31.
 */

public  class MyViewGroup extends ViewGroup {
    private static final String TAG = MyViewGroup.class.getCanonicalName();
    private int mChildrensize;
    private int mChildenswidth;
    private int mChildensindex;

    //记录上次滑动的坐标
    private  int mLastX = 0;
    private  int mLastY = 0;

    //记录上次滑动的坐标（onInterceptTouchEvent）
    private  int mLastXIntercept = 0;
    private  int mLastYIntercept = 0;

    //处理滑动
    private Scroller mScroller;
    //追踪触摸事件速率的追踪器
    private VelocityTracker mVelocityTracker ;

    public MyViewGroup(Context context) {
        super(context);
        init();
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }


    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }


    private void init() {
        if (mScroller == null) {
            mScroller = new Scroller(getContext());
            mVelocityTracker =VelocityTracker.obtain();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean mIntercept = false;

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()){
            case  MotionEvent.ACTION_DOWN:{
                mIntercept = false;
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                    mIntercept = true ;
                }
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                if (Math.abs(deltaX)>Math.abs(deltaY)){
                  mIntercept = true;
                }else {
                    mIntercept = false;
                }
                break;
            }
            case MotionEvent.ACTION_UP:{
                mIntercept = false;
                break;
            }

            default:
                break;

        }

        Log.e(TAG, "onInterceptTouchEvent: "+mIntercept );

        mLastX = x;
        mLastY = y;
        mLastXIntercept = x;
        mLastYIntercept = y;

        return mIntercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mVelocityTracker.addMovement(event);

        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:{
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                break;
            }
            case MotionEvent.ACTION_MOVE:{

                int deltaX = x - mLastX;
                int deltaY = y - mLastY;

                scrollBy(-deltaX,0);
                break;
            }
            case  MotionEvent.ACTION_UP:{
                int scaleX = (int) getScaleX();
                mVelocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) mVelocityTracker.getXVelocity();
                if (Math.abs(xVelocity)>50){
                    mChildensindex = xVelocity>0 ?mChildensindex-1:mChildensindex+1;
                }else {
                    mChildensindex =(scaleX +mChildenswidth/2) /mChildenswidth;
                }
                mChildensindex = Math.max(0,Math.min(mChildensindex,mChildrensize-1));
                int dx =mChildensindex*mChildenswidth-scaleX;
                smoothScrollBy(dx,0);
                mVelocityTracker.clear();
                break;
            }
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth  = 0;
        int measuredHeight = 0;

        int childCount = getChildCount();
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthMeasureSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMeasureSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (childCount==0){
            setMeasuredDimension(0,0);
        }else if (widthMeasureSpecMode==MeasureSpec.AT_MOST && heightMeasureSpecMode==MeasureSpec.AT_MOST){
            final View childview = getChildAt(0);
            measuredWidth = childview.getMeasuredWidth()*childCount;
            measuredHeight = childview.getMeasuredHeight();
            setMeasuredDimension(measuredWidth,measuredHeight);
        }else if (heightMeasureSpecMode == MeasureSpec.AT_MOST){
            final View childview = getChildAt(0);
            measuredHeight = childview.getMeasuredHeight();
            setMeasuredDimension(widthMeasureSpecSize,measuredHeight);
        }else if (widthMeasureSpecMode == MeasureSpec.AT_MOST){
            final View childview = getChildAt(0);
            measuredWidth = childview.getMeasuredWidth()*childCount;
            setMeasuredDimension(measuredWidth,heightMeasureSpecSize);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = 0;
         final int childCount = getChildCount();
         mChildrensize = childCount;

        for (int i = 0; i < childCount; i++) {
            final View childview = getChildAt(i);

            if (childview.getVisibility()!= GONE){
                final int measuredWidth = childview.getMeasuredWidth();
                mChildenswidth = measuredWidth;

                childview.layout(childLeft,0,childLeft+measuredWidth,childview.getHeight());
                childLeft += measuredWidth;
            }

        }
    }

    private void smoothScrollBy(int dx, int i) {
        mScroller.startScroll(getScrollX(),0,dx,0,500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
           scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
           postInvalidate();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mVelocityTracker.recycle();
        super.onDetachedFromWindow();
    }
}
