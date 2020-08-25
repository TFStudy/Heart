package com.tf.my.myview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PayTestView extends View {

    private float mProgress; // 代表动画当前进度

    private Paint mBluePaint; // 蓝色画笔

    private float start;

    private ValueAnimator mLoadingAnimator;
    private PathMeasure mLoadingPathMeasure;
    private Path mDstPath; // 保存PathMeasure切割后的内容

    public PayTestView(Context context) {
        super(context);
        init();
    }

    public PayTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PayTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 取消硬件加速
        // 画笔设置
        mBluePaint = new Paint(Paint.ANTI_ALIAS_FLAG); // 画笔抗锯齿
        mBluePaint.setColor(Color.BLUE);
        mBluePaint.setStyle(Paint.Style.STROKE);
        mBluePaint.setStrokeWidth(10);
        mBluePaint.setStrokeCap(Paint.Cap.ROUND);
        // 新建 PathMeasure
        Path loadingPath = new Path();
        loadingPath.addCircle(100, 100, 60, Path.Direction.CW); // CW代表顺时针
        mLoadingPathMeasure = new PathMeasure(loadingPath, false);
        mDstPath = new Path();
        // 动画
        mLoadingAnimator = ValueAnimator.ofFloat(0, 1);
        mLoadingAnimator.setDuration(1500);
        mLoadingAnimator.setRepeatMode(ValueAnimator.RESTART);
        mLoadingAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mLoadingAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        mLoadingAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDstPath.reset();
        float length = mLoadingPathMeasure.getLength();
        float stop = length * mProgress;
        if (mProgress <= 0.5){
            start = 0 * length;
        }else if (mProgress > 0.5) {
            start = (mProgress * 2 - 1) * length;
        }
        mLoadingPathMeasure.getSegment(start, stop, mDstPath, true);
        canvas.drawPath(mDstPath, mBluePaint);
    }
}
