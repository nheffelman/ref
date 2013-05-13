package com.example.refsbitch;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.RefsBitch.R;

public class MainActivity extends Activity implements OnClickListener  {

	int team1color;
	private Spinner spinner1;
	public String ageresult = null;
	int initialColor = 0xff0000ff;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        View button = findViewById(R.id.selectteamcolor_button);
        button.setOnClickListener(this);
        
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
		startActivity(i);
	}


	
}
