package com.joshuahou.survivalphrases;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

public class Main extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        int colWidth = getWindowManager().getDefaultDisplay().getWidth() / 3 * 85 / 100;
        gridview.setAdapter(new ImageAdapter(this, spinner, colWidth));
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
