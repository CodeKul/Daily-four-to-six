package com.codekul.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by aniruddha on 8/6/17.
 */

public class CodeView extends android.support.v7.widget.AppCompatEditText {

    private Paint paint;

    public CodeView(Context context) {
        super(context); // via code

        initPaint();
    }

    public CodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs); // via xml

        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2.0f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(40, 50, 30, paint);
        canvas.drawLine(40, 50, 400, 400 ,paint);
    }
}


