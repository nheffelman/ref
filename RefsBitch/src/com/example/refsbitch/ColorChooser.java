package com.example.refsbitch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.RefsBitch.R;

public class ColorChooser extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.gridview);
       GridView gridView = (GridView) findViewById(R.id.pictureGrid);
       
       // Instance of ImageAdapter Class
       gridView.setAdapter(new ImageAdapter(this));
	}
		
}
