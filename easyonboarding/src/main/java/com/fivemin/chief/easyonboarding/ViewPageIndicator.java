package com.fivemin.chief.easyonboarding;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chief on 18/4/18.
 */

public class ViewPageIndicator extends View {

    Context context;
    private int radius;
    private int width;
    private int countIndicater;
    private int positionIndicater;
    private Paint activePageIndicater;
    private Paint inactivePageIndicater;

    public ViewPageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        activePageIndicater = new Paint(Paint.ANTI_ALIAS_FLAG);
        activePageIndicater.setColor(Color.WHITE);

        inactivePageIndicater = new Paint(Paint.ANTI_ALIAS_FLAG);
        inactivePageIndicater.setColor(getResources().getColor(R.color.colorDots));

        radius = 15;
        width = radius * 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < countIndicater; i++) {
            if (i != positionIndicater) {
                canvas.drawCircle(radius + (width * i), radius, radius / 2,
                        inactivePageIndicater);
            }
        }
        canvas.drawCircle(radius + (width * positionIndicater), radius, radius / 2,
                activePageIndicater);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = width * countIndicater;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    public void setInactiveIndicatorColor(@ColorRes int color) {
        inactivePageIndicater.setColor(ContextCompat.getColor(context, color));
        invalidate();
    }

    public void setCurrentPage(int position) {
        this.positionIndicater = position;
        invalidate();
    }

    public void setPageIndicators(int size) {
        this.countIndicater = size;
        invalidate();
    }

    public void setActiveIndicatorColor(@ColorRes int color) {
        activePageIndicater.setColor(ContextCompat.getColor(context, color));
        invalidate();
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 2 * radius + getPaddingTop() + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
