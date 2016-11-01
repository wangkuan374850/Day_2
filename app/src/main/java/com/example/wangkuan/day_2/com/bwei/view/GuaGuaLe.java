package com.example.wangkuan.day_2.com.bwei.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.wangkuan.day_2.R;


/**
 * Created by wangkuan on 2016/11/1.
 */
public class GuaGuaLe extends View {



    private int startAngle;
    private int sweepAngle;
    private int mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private Paint mArcPaint;
    private RectF mRectF;

    public GuaGuaLe(Context context) {

        this(context, null);


    }

    public GuaGuaLe(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        //获得stylesd下styleable的属性节点
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.circleView);
        //判断不为空
        if (ta != null) {
            //对应外环的起始角度
            startAngle = ta.getInt(R.styleable.circleView_startAngle, 0);
            //对应外环的扫描角度
            sweepAngle = ta.getInt(R.styleable.circleView_sweepAngle, 180);
            //释放typedarry资源
            ta.recycle();
        }
    }

    public GuaGuaLe(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //得到控件的宽和高
        int length = Math.min(w, h);
        //
        mCircleXY = length / 2;
        //半径
        mRadius = length * 0.5f / 2;
        //得到画笔，设置不能有相同的画笔，也就是只能这个用,画内圆
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.GREEN);//设置颜色
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);
        //画外圆
        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(Color.CYAN);//设置颜色
        mArcPaint.setStyle(Paint.Style.STROKE);//设置风格
        mArcPaint.setStrokeWidth((w * 0.1f));//设置风格的宽

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        //画弧度
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
