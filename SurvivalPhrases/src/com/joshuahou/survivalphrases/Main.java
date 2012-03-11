package com.joshuahou.survivalphrases;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }

    @Override
    protected void onResume() {
        PlayClip.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        PlayClip.release();
        super.onPause();
    }
}
