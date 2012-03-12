package com.joshuahou.survivalphrases;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private Spinner spinner;

    public ImageAdapter(Context context, Spinner spinner) {
        this.context = context;
        this.spinner = spinner;
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
                String language = spinner.getSelectedItem().toString();
                PlayClip.play(context, language.toLowerCase() + "/" + soundIds[position]);
            }
        });
        return imageView;
    }
    
    private String[] soundIds = {
            "atm.mp3",
            "hotel.mp3",
            "camera.mp3",
            "mail.mp3",
            "martini.mp3",
            "nurse.mp3",
            "plane.mp3",
            "police.mp3",
            "present.mp3",
            "restaurant.mp3",
            "taxi.mp3",
            "restroom.mp3",
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
