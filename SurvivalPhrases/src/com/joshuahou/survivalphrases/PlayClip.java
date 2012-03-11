package com.joshuahou.survivalphrases;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;

public class PlayClip {
    private final static String TAG = "PlayClip";
    private static SoundPool pool;

    public static void play(Context context, int resId) {
        final int playId = pool.load(context, resId, 1);
        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // must wait till sound is done loading
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                //  int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
                soundPool.play(playId, 1, 1, 1, 0, 1);
            }
        });
    }
    
    public static void resume() {
        pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
    }

    public static void release() {
        pool.release();
    }
}
