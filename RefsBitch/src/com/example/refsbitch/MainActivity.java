package com.example.refsbitch;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;


import com.example.RefsBitch.R;

public class MainActivity extends Activity implements OnClickListener  {
	public int id = 0;
	String t1name = null;
	String t2name = null;
	int color = 0;
	int team1color = 0;
	int team2color = 0;
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
        
        Button kickoffbutton = (Button) findViewById(R.id.goto_kickoff_button);
        kickoffbutton.setOnClickListener(this);
        
        ImageButton t1cbutton = (ImageButton) findViewById(R.id.t1c_button);
        t1cbutton.setOnClickListener(this);
        
        ImageButton t2cbutton = (ImageButton) findViewById(R.id.t2c_button);
        t2cbutton.setOnClickListener(this);
        
        EditText team1name = (EditText)this.findViewById(R.id.t1name);
        team1name.setHint("Team 1");
        t1name = team1name.getText().toString();
        EditText team2name = (EditText)this.findViewById(R.id.t2name);
        team2name.setHint("Team 2");
        t2name = team2name.getText().toString();
        
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
		switch (v.getId()) {
		case R.id.t1c_button:
			id = R.id.t1c_button;
			Intent i = new Intent(this, ColorChooser.class);
			startActivityForResult(i, color);
		break;
		case R.id.t2c_button:
			id = R.id.t2c_button;
			Intent g = new Intent(this, ColorChooser.class);
			startActivityForResult(g, color);
		break;
		//sends all the info to the kickoff page
		case R.id.goto_kickoff_button:
			EditText team1name = (EditText)this.findViewById(R.id.t1name);
			t1name = team1name.getText().toString();
			EditText team2name = (EditText)this.findViewById(R.id.t2name);
	        team2name.setHint("Team 2");
	        t2name = team2name.getText().toString();
	        spinner1 = (Spinner) findViewById(R.id.spinner1);
	        ageresult = spinner1.getSelectedItem().toString();
			Bundle basket = new Bundle();
			basket.putString("team1name", t1name);
			basket.putString("team2name", t2name);
			basket.putInt("team1color", team1color);
			basket.putInt("team2color", team2color);
			basket.putString("age", ageresult);
			Intent k = new Intent(MainActivity.this, KickOff.class);
			k.putExtras(basket);
			startActivity(k);
		break;	
			
	}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle basket = data.getExtras();
			color = basket.getInt("keywhatevs");
			switch (id) {
			//returns the color from choose color and sets it to team 1
			case R.id.t1c_button:
				ImageButton t1cbutton = (ImageButton) findViewById(R.id.t1c_button);
				team1color = id;
				t1cbutton.setImageResource(colors[color]);
			break;
			//returns the color from choose color and sets it to team 2
			case R.id.t2c_button:
				ImageButton t2cbutton = (ImageButton) findViewById(R.id.t2c_button);
				team2color = id;
				t2cbutton.setImageResource(colors[color]);
			break;
			}
				
				
		}
	}

		
}
