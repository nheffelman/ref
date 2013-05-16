package com.example.refsbitch;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.RefsBitch.R;

public class MainActivity extends Activity implements OnClickListener  {
	int color = 0;
	private Spinner spinner1;
	public String ageresult = null;
	int initialColor = 0xff0000ff;
	int colors[] = {R.drawable.orange, R.drawable.yellow,
    		R.drawable.blue, R.drawable.pink,
    		R.drawable.indigo, R.drawable.violet,
    		R.drawable.black, R.drawable.white,
    		R.drawable.red, R.drawable.green,
    		R.drawable.gray, R.drawable.blackandwhite,
    		R.drawable.blackandgold, R.drawable.blackandred,
    		R.drawable.blue2};
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageButton t1cbutton = (ImageButton) findViewById(R.id.t1c_button);
        t1cbutton.setOnClickListener(this);
        
        ImageButton t2cbutton = (ImageButton) findViewById(R.id.t2c_button);
        t2cbutton.setOnClickListener(this);
        
        
        findViews();
        setAdapters();
        
        ageresult = spinner1.getSelectedItem().toString();
        
        
        
    }


    private void setAdapters() {
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
    			this, R.array.ages, android.R.layout.simple_spinner_dropdown_item);
    	
    	adapter.setDropDownViewResource(
    			android.R.layout.simple_spinner_item);
    	spinner1.setAdapter(adapter);
		
	}


	private void findViews() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(this, ColorChooser.class);
		startActivityForResult(i, color);
		
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle basket = data.getExtras();
			color = basket.getInt("keywhatevs");
			Toast.makeText(MainActivity.this, "" + color, Toast.LENGTH_SHORT).show();
			ImageButton t1cbutton = (ImageButton) findViewById(R.id.t1c_button);
			t1cbutton.setImageResource(colors[color]);
			
			
			
			
		}
	}

		
}
