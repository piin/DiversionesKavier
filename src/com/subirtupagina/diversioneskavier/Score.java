package com.subirtupagina.diversioneskavier;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.TableRow.LayoutParams; 
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Score extends Activity {
	MediaPlayer bt;
	int count;
	String name[] = new String [10];
	String score[] = new String [10];
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	
    	
    	bt = MediaPlayer.create(Score.this, R.raw.button);
    	
		// delete bar title
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
		         
		//delete bar task
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        
        Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	bt.start();
                Score.this.finish();
            }
        });
        //Score.this.finish();
        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        TableLayout table2 = (TableLayout) findViewById(R.id.tablelayout2);
        
        /*******     BD      ***********/
        Handler_sqlite helper= new Handler_sqlite(this);
    	helper.openDB();
    	count=helper.scan(name,score);
    	helper.closeDB();
    	/******************************/

    	for( int i = 0 ; i < count ; i++ ){
    		TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            row.setId(i);
        	TextView txt = new TextView(this);
    		txt.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
    		
    		txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    		txt.setTextColor(Color.WHITE);
    		
    		txt.setText(i+1+".- " + name[i]);
            row.addView(txt);
           
            table.addView(row);  
    	}
    	for( int i = 0 ; i < count ; i++ ){
    		TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            row.setId(i);
        	TextView txt = new TextView(this);
    		txt.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
    		
    		txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
    		txt.setTextColor(Color.WHITE);
    		
    		txt.setText(score[i]);
            row.addView(txt);
           
            table2.addView(row);  
    	}
    	
	    
    }

}
