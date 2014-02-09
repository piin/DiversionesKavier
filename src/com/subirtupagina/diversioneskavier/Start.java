package com.subirtupagina.diversioneskavier;

import java.util.Random;


import android.media.AudioManager;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Start  extends SelectLanguage{
	
	
	SoundManager snd;
	static final int mistakes = 4;
	static final int animals = 0 , movies=1 , sports = 2, artist = 3,colors=4,countries=5,food=6,brand=7; 
	Random r=new Random();
	Random t=new Random();
	static int record=0;
	int rand;
	static final String youlose="YOU LOSE!!",youwin="YOU WIN!!";
	TextView text,title;
	StringBuffer word,type;
	int cont_mistakes=0;
	Guess guess;
	ImageView head,torso,body,arms;
	Handler_sqlite helper;
	int correct, error,gameover,win,warning;
	
    @Override
    protected void onCreate (Bundle savedInstanceState){
    	/******** SOUND ***************/
    	snd = new SoundManager(getApplicationContext());
    	 
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        correct = snd.load(R.raw.correct);
        error = snd.load(R.raw.error);
        gameover = snd.load(R.raw.game_over);
        win = snd.load(R.raw.applause);
        warning = snd.load(R.raw.warning);
    	
    	/*******     BD      ***********/
    	helper= new Handler_sqlite(this);
    	helper.openDB();
    	/********   WORDS      *******/
    	rand=r.nextInt(20);
    	guess = new Guess();
    	switch(r.nextInt(8)){
    	
    		case animals:
    					guess.animals(selected);
    					break;
    		case movies:
    					guess.movies(selected);
    					break;
    		case sports:
    					guess.sports(selected);
    					break;
    		case artist:
    					guess.artist(selected);
    					break;
    		case colors:
						guess.colors(selected);
						break;
    		case countries:
						guess.countries(selected);
						break;
    		case food:
						guess.food(selected);
						break;
    		case brand:
						guess.brand(selected);
						break;
    	}
    	
    	word = new StringBuffer(guess.word[rand]);
    	
    	
        /****************************/
    	
    	// delete bar title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
         
        //delete bar task
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
	    
        text = (TextView) this.findViewById(R.id.textView1);
        title = (TextView) this.findViewById(R.id.category);
        for(int i=0 ; i<guess.word[rand].length() ; i++){
        	if( guess.word[rand].charAt(i) != ' ')
        		word.setCharAt(i,'-');
        }
        
	    text.setText(word);
	    title.setText(guess.type);
    	/*******    Images    **********/
    	head = (ImageView ) findViewById(R.id.head);
    	torso = (ImageView ) findViewById(R.id.torso);
    	arms = (ImageView ) findViewById(R.id.arms);
    	body = (ImageView ) findViewById(R.id.body);
    }
    void dialog(final String s){
    	AlertDialog.Builder dialog = new AlertDialog.Builder(this);
    	
    	dialog.setTitle("\t\t\t\t\t\t\t\t\t\t"+s);
    	dialog.setMessage("\t\t\t\t\t\t\tYOUR SCORE "+ record +"pts");
    	dialog.setPositiveButton("Continue", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	if( s.equals(youlose) ){
            		snd.pause(gameover);
	                Start.this.finish();
            	}
            	else if( s.equals(youwin) ){
            		snd.pause(win);
            		Intent intent = new Intent(Start.this,StartNext.class);
        			startActivity(intent);
        			Start.this.finish();
            	}
                dialog.cancel();
            }
        });
    	dialog.create();
    	dialog.show();
    }

    //to change button visibility
    public void dissapear(View v) {
    	
    	Button boton = (Button) findViewById(v.getId());
    	boton.setVisibility(View.INVISIBLE); 
    	String letter=boton.getText().toString();
    	
    	if( guess.word[rand].indexOf(letter) != -1 ){
    		snd.play(correct);
    		for( int i=0 ; i < guess.word[rand].length() ; i++ ){
    			if( guess.word[rand].charAt(i) == letter.charAt(0) ){
    				word.setCharAt( i,  guess.word[rand].charAt(i) );
    			}
    				
    		}
    		if( guess.word[rand].equals(word.toString()) ){
    			snd.play(win);	
    			record=0;
    			record+=5;
    			dialog(youwin);
    		}
    	}
    	
    	else{
    		snd.play(error);
    		switch(cont_mistakes){
    		case 0://head
    				head.setVisibility(View.VISIBLE);
    				break;
    		case 1://torso
    				head.setVisibility(View.INVISIBLE);
    				torso.setVisibility(View.VISIBLE);
    				break;
    		case 2://arms
    				torso.setVisibility(View.INVISIBLE);
    				arms.setVisibility(View.VISIBLE);
    				break;
    		case 3://body
    				arms.setVisibility(View.INVISIBLE);
    				body.setVisibility(View.VISIBLE);
    				break;
    		case 4://game over
    				snd.play(gameover);
	    			dialog(youlose);
    				break;
    		}
    		cont_mistakes++;	
    	}
    	
    	text.setText( word );

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	
      if (keyCode == KeyEvent.KEYCODE_BACK) {
    	  snd.play(warning);
        new AlertDialog.Builder(this)
          .setIcon(R.drawable.sad)
          .setTitle("ALERT")
          .setMessage("Are you sure you want lose this game?")
          .setNegativeButton("Return", null)//without listener
          .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
				            @Override
				            public void onClick(DialogInterface dialog, int which){
				              //exit
				            	Start.this.finish();
				            }
				          })
          .show();
        //if the listener returns true, means event is processing, and nobody can't do anything
        return true;
      }
      //return the listener
       return super.onKeyDown(keyCode, event);
    }

}
	