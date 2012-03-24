package com.joshuahou.survivalphrases;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

public class Main extends Activity {
    private Spinner spinner;
    private SharedPreferences preferences;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // set language selection to what's saved in shared preferences, defaults to English
        spinner.setSelection(preferences.getInt("position", 0));

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

    @Override
    protected void onDestroy() {
        // save language selection
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("position", spinner.getSelectedItemPosition());
        editor.commit();
        super.onStop();
    }
}
