package com.healthsignz.training.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Bhuvanesh on 4/3/2016.
 */
public class PieChart extends View {

    private Paint paint = new Paint();
    private float[] value_degree;
    RectF rectf = new RectF(120, 120, 380, 380);
    float temp = 0;

    public PieChart(Context context, float[] values) {
        super(context);

        value_degree = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            value_degree[i] = values[i];
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Random r;
        for (int i = 0; i < value_degree.length; i++) {
            if (i == 0) {
                r = new Random();
                int color = Color.argb(100, r.nextInt(256), r.nextInt(256), r.nextInt(256));
                paint.setColor(color);
                canvas.drawArc(rectf, 0, value_degree[i], true, paint);
            } else {
                temp += value_degree[i - 1];
                r = new Random();
                int color = Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256));
                paint.setColor(color);
                canvas.drawArc(rectf, temp, value_degree[i], true, paint);
            }
        }
    }
}

