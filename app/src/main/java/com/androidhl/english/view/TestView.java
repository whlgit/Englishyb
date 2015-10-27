package com.androidhl.english.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.androidhl.english.utils.MediaPlayerUtils;

import java.io.FileDescriptor;

public class TestView extends ImageView{

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private MediaInter metiaInter;

    public void setMetiaInter(MediaInter metiaInter) {
        this.metiaInter = metiaInter;
        setImageBitmap(metiaInter.getBitmap());
    }



    public interface MediaInter{
        Bitmap getBitmap();
        FileDescriptor getPath();
    }



    public TestView(Context context) {
        this(context,null);
    }



}
