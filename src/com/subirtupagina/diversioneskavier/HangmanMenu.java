package com.subirtupagina.diversioneskavier;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class HangmanMenu extends Activity {
	MediaPlayer bg,bt,ex,wr,bg2;
	MediaPlayer bgStart,win,correct,error,gameover;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//Log.i("HEY", selected);
    	/*** Sound  ***/ 
    	bg = MediaPlayer.create(HangmanMenu.this, R.raw.background);
    	bt = MediaPlayer.create(HangmanMenu.this, R.raw.button);
    	wr = MediaPlayer.create(HangmanMenu.this, R.raw.warning);
    	ex = MediaPlayer.create(HangmanMenu.this, R.raw.exit);
    	/**************/ 
    	 setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
    	
    	// delete bar title
 		requestWindowFeature(Window.FEATURE_NO_TITLE);
          
         //delete bar task
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman_menu);
    }
    @Override
    protected void onResume(){
    	super.onResume();
    	bg.seekTo(0);
    	bg.start();
    	bg.setLooping(true);
    }
	public void exitAlert(View view) {
		bt.start();
		wr.start();
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage("Are you sure you want to quit?")
    	        .setTitle("Alert")
    	        .setCancelable(false)
    	        .setIcon(R.drawable.sad)
    	        .setNegativeButton("Return",
    	                new DialogInterface.OnClickListener() {
    	                    public void onClick(DialogInterface dialog, int id) {
    	                        dialog.cancel();
    	                    }
    	                })
    	        .setPositiveButton("Quit",
    	                new DialogInterface.OnClickListener() {
    	                    public void onClick(DialogInterface dialog, int id) {
    	                    	exit();
    	                    }
    	                });
    	AlertDialog alert = builder.create();
    	alert.show();

    	
    }
    public void exit(){
    	ex.start();
    	while( ex.isPlaying() == true){
    		//do nothing
    	}
    	System.exit(0);
    }
    public void start(View view){
    	bg.pause();
        bt.start();
    	Intent intent = new Intent(HangmanMenu.this, SelectLanguage.class);
    	startActivity(intent);
    	
    }
    public void score(View view){
    	bt.start();
    	Intent intent = new Intent(this, Score.class);
    	startActivity(intent);
    }
    public void soundPressed(View view){
    	Button boton = (Button) findViewById(R.id.button4); 
    	Button boton2= (Button) findViewById(R.id.button5);
    	boton.setVisibility(View.INVISIBLE);
    	boton2.setVisibility(View.VISIBLE);
    	bt.start();
    	bg.pause();	
    }
    public void notsoundPressed(View view){
    	Button boton = (Button) findViewById(R.id.button4); 
    	Button boton2= (Button) findViewById(R.id.button5);
    	boton.setVisibility(View.VISIBLE);
    	boton2.setVisibility(View.INVISIBLE);
    	bt.start();
    	bg.seekTo(0);
		bg.start();
		bg.setLooping(true);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {
    	  wr.start();
        new AlertDialog.Builder(this)
          .setIcon(R.drawable.sad)
          .setTitle("ALERT")
          .setMessage("Are you sure you want to quit?")
          .setNegativeButton("Return", null)//without listener
          .setPositiveButton("Quit", new DialogInterface.OnClickListener() {//listener which close the activity
				            @Override
				            public void onClick(DialogInterface dialog, int which){
				              //exit
				              exit();
				            }
				          })
          .show();
        //if the listener returns true, means event is processing, and nobody can't do anything
        return true;
      }
      //return event its own place
      return super.onKeyDown(keyCode, event);
    }
    

}
