package com.joshuahou.survivalphrases;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class PlayClip {
    private final static String TAG = "PlayClip";
    private static MediaPlayer mp = new MediaPlayer();

    public static void play(Context context, int id) {
        AssetFileDescriptor afd = context.getResources().openRawResourceFd(id);

        try { // need to release()
            mp.reset();
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            mp.prepare();
            mp.start();
            afd.close();
        } catch (IOException e) {
            Log.e(TAG, "Can't play audio because: " + e.getMessage());
        }
    }

    public static void release() {
        mp.release();
    }
}
