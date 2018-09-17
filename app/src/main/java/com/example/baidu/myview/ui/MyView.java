package com.example.baidu.myview.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.baidu.myview.R;

/**
 * Created by baidu on 2018/8/31.
 */

public class MyView extends View {
    private int mColor = Color.RED;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
         mColor =typedArray.getColor(R.styleable.MyView_viewColor,Color.RED);
        typedArray.recycle();
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMeasureMode == MeasureSpec.AT_MOST && heightMeasureMode ==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,200);
        }else if (widthMeasureMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(200,heightSize);
        }else if (heightMeasureMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,200);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth()-paddingLeft-paddingRight;
        int height = getHeight()-paddingTop-paddingBottom;
        int radius = Math.min(width,height)/2;
        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,radius,mPaint);
    }
}
