package com.joshuahou.survivalphrases;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return thumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return thumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(thumbIds[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayClip.play(context, soundIds[position]);
            }
        });
        return imageView;
    }
    
    private String[] soundIds = {
            "english/atm.mp3",
            "english/hotel.mp3",
            "english/camera.mp3",
            "english/mail.mp3",
            "english/martini.mp3",
            "english/nurse.mp3",
            "english/plane.mp3",
            "english/police.mp3",
            "english/present.mp3",
            "english/restaurant.mp3",
            "english/taxi.mp3",
            "english/restroom.mp3",
    };

    // references to our images
    private Integer[] thumbIds = {
            R.drawable.atm,
            R.drawable.bed,
            R.drawable.camera,
            R.drawable.mail,
            R.drawable.martini,
            R.drawable.nurse,
            R.drawable.plane,
            R.drawable.police,
            R.drawable.present,
            R.drawable.restaurant,
            R.drawable.taxi,
            R.drawable.unisex,
    };
}
