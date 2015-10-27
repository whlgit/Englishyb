package com.androidhl.english.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public class AssetsUtils {

    public static Bitmap getAssetsBitmap(String bitmapName,Context context){
        Bitmap bitmap= null;
        AssetManager assets = context.getResources().getAssets();
        String path = null;
        path = "image"+File.separator+bitmapName+".png";
        try {
            InputStream open = assets.open(path);
            bitmap= BitmapFactory.decodeStream(open);
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static String[] getLists(String path,Context context){
        AssetManager assets = context.getResources().getAssets();
        String[] list = null;
        try {
            list = assets.list(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }

    private static String getAssetsFile(AssetManager assets, String bitmapName) {
        String path = null;
        try {
            String[] list = assets.list(bitmapName);
            if (list.length>0){
                for (int x = 0;x<list.length;x++) {
                    File file = new File(list[x]);
                    if (file.exists())
                        path = file.getName();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public static AssetFileDescriptor getAssetsMusicPath(String musicName,Context context){
        AssetFileDescriptor musicPath= null;
        AssetManager assets = context.getResources().getAssets();
        String path = null;
        path = "music"+File.separator+musicName+".mp3";
        try {
            musicPath = assets.openFd(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return musicPath;
    }

}
