package com.androidhl.english.utils;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.FileDescriptor;

/**

 */
public class MediaPlayerUtils {


    private static MediaPlayer mediaPlayer;
    private static boolean playState = false;

    public static void cleanSpeech()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public static void start(AssetFileDescriptor fileDescriptor){
        if (!playState)
        {
            mediaPlayer = new MediaPlayer();
            try
            {
                mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),fileDescriptor.getStartOffset(),fileDescriptor.getLength());
                fileDescriptor.close();
                mediaPlayer.prepare();
                mediaPlayer.start();
                playState = true;
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {

                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        if (playState)
                        {
                            playState = false;
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                    }
                });
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            if (mediaPlayer.isPlaying())
            {
                mediaPlayer.stop();
                playState = false;
                mediaPlayer.release();
                mediaPlayer = null;
            }
            else
            {
                playState = false;
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }


    }
    public static void speeching(String path)
    {
        if (!playState)
        {
            mediaPlayer = new MediaPlayer();
            try
            {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
                mediaPlayer.start();
                playState = true;
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {

                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        if (playState)
                        {
                            playState = false;
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                    }
                });
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            if (mediaPlayer.isPlaying())
            {
                mediaPlayer.stop();
                playState = false;
                mediaPlayer.release();
                mediaPlayer = null;
            }
            else
            {
                playState = false;
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }


    }

}
