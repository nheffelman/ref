package com.example.refsbitch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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

       gridView.setOnItemClickListener(new OnItemClickListener() {
	 	   

       public void onItemClick(AdapterView<?> parent, View v, int position,
			long id) {
    		//Toast.makeText(ColorChooser.this, "" + position, Toast.LENGTH_SHORT).show();
    		Intent person = new Intent();
    		Bundle backpack = new Bundle();
    		backpack.putInt("keywhatevs", position);
    		person.putExtras(backpack);
    		setResult(RESULT_OK, person);
    		finish();
            }
       });
    	  

         
       
       

	}
	
	
}
