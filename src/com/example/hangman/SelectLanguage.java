package com.example.hangman;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.view.View;

public class SelectLanguage extends  Activity{
	static final String[] languages = new String[]{"English","Spanish"};
	ListView lv;
	static String selected;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    	// delete bar title
    	requestWindowFeature(Window.FEATURE_NO_TITLE);       
    	 //delete bar task
    	 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_language);
    	lv = (ListView)findViewById(R.id.listView1);
    	lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,languages));
    	lv.setOnItemClickListener(new OnItemClickListener() {    
    		public void onItemClick(AdapterView<?> parent, View view,        
    				int position, long id) {      
    			// When clicked, show a toast with the TextView text      
    			Toast.makeText(getApplicationContext(), ((TextView) view).getText(),Toast.LENGTH_SHORT).show();
    			selected=languages[position];
    			Intent intent = new Intent(SelectLanguage.this, Start.class);
    			startActivity(intent);
    			SelectLanguage.this.finish();
    			
    			}  
    		});
    	} 
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {
    	  return true;
      }
      return super.onKeyDown(keyCode, event);
	}
	
}