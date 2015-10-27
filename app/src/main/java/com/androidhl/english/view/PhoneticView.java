package com.androidhl.english.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;

import com.androidhl.english.R;
import com.androidhl.english.bean.MenuComponent;
import com.androidhl.english.utils.AssetsUtils;
import com.androidhl.english.utils.MediaPlayerUtils;

public class PhoneticView  extends View{
    private MenuComponent menuComponent;
    private Context context;
    private float width=60;
    private float height=90;
    int widthDip = 48;
    int heightDip = 72;
    Bitmap bitmap = null;
    Paint paint;

    public PhoneticView(Context context) {
        super(context);
        this.context = context;
        inflate();
    }

    private void inflate() {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        width = density*widthDip;
        height = density*heightDip;
        paint = new Paint();
        paint.setAlpha(180);
        paint.setAntiAlias(false);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void setMenuComponent(MenuComponent menuComponent) {
        this.menuComponent = menuComponent;
        bitmap = AssetsUtils.getAssetsBitmap(menuComponent.getName(),context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect rect = new Rect(0,0,(int)width,(int)height);
        canvas.clipRect(rect);
        Path path = new Path();
        path.moveTo(1,1);
        path.lineTo(width - 1, 1);
        path.lineTo(width - 1, height - 1);
        path.lineTo(1, height-1);
        path.close();
        paint.setColor(Color.GREEN);
        canvas.drawPath(path, paint);
        if (menuComponent==null){
            drawText(canvas,rect,"暂无");
        } else {
            int cheight = (int) (height/3);
            Rect bitmapRect = new Rect(0,0,(int)width,cheight*2);
            canvas.drawBitmap(bitmap,bitmapRect,bitmapRect,paint);
            Rect textRect = new Rect(0,cheight*2,(int)width,cheight*3);
            drawText(canvas,textRect,menuComponent.getDescription());
        }

    }
    private void drawText(Canvas canvas, Rect targetRect,String text){
        paint.setColor(Color.GRAY);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        int baseline = targetRect.top + (targetRect.bottom - targetRect.top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, targetRect.centerX(), baseline, paint);
    }
    private void test(Canvas canvas) {
        Rect targetRect = new Rect(50, 50, 1000, 200);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(3);
        paint.setTextSize(80);
        String testString = "测试：ijkJQKA:1234";
        paint.setColor(Color.CYAN);
        canvas.drawRect(targetRect, paint);
        paint.setColor(Color.RED);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();

        int baseline = targetRect.top + (targetRect.bottom - targetRect.top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(testString, targetRect.centerX(), baseline, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) width, (int) height);
    }
}
