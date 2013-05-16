package com.example.refsbitch;

import com.example.RefsBitch.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    
 // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
 
    // Keep all Images in array
    public Integer[] mThumbIds = {
    		R.drawable.orange, R.drawable.yellow,
    		R.drawable.blue, R.drawable.pink,
    		R.drawable.indigo, R.drawable.violet,
    		R.drawable.black, R.drawable.white,
    		R.drawable.red, R.drawable.green,
    		R.drawable.gray, R.drawable.blackandwhite,
    		R.drawable.blackandgold, R.drawable.blackandred,
    		R.drawable.blue2
            
    };
 
    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
 
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    //@Override
   // public View getView(int position, View convertView, ViewGroup parent) {
    //    ImageView imageView = new ImageView(mContext);
      //  imageView.setImageResource(mThumbIds[position]);
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        //return imageView;
   // }
 
}