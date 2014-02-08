package com.example.hangman;

import java.util.Random;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class StartNext  extends Start{
	
	static final int mistakes = 4;
	Random r=new Random();
	Random r2=new Random();
	int record_next;
	String name;
	int rand;
	static final String youlose="YOU LOSE!!",youwin="YOU WIN!!";
	TextView text,title;
	StringBuffer word,type;
	int cont_mistakes=0;
	Guess guess;
	ImageView head,torso,body,arms;
	EditText input;
    @Override
    protected void onCreate (Bundle savedInstanceState){
    	
    	/********   WORDS      *******/
    	rand=r.nextInt(20);
    	guess = new Guess();
    	switch(r2.nextInt(8)){
    	
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

		setRequestedOrientation(ActivityInfo. SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
    	
		// delete bar title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		         
		//delete bar task
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_next);
	    
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
    	if( s.equals(youlose) ){
    		input = new EditText(this);
    		InputFilter[] filterArray = new InputFilter[1];
        	filterArray[0] = new InputFilter.LengthFilter(10);
        	input.setFilters(filterArray);
        	input.setHint("ENTER YOUR NAME");
        	dialog.setView(input);
    	}
    	dialog.setPositiveButton("Continue", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	if( s.equals(youlose) ){
            		if(input.getText().toString() == "")
	            		name="UNKNOWN";
	            	else
	            		name=input.getText().toString();
	            	helper.insertReg(name, record);
                	helper.closeDB();
                	Intent intent = new Intent(StartNext.this,Score.class);
        			startActivity(intent);
	                StartNext.this.finish();
	                record=0;
            	}
            	else if( s.equals(youwin) ){
            		Intent intent = new Intent(StartNext.this,StartNext.class);
        			startActivity(intent);
        			intent.putExtra("record", record);
        			StartNext.this.finish();
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
    		case 4://gameover
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
    	  final EditText input = new EditText(this);
	      	input.setHint("ENTER YOUR NAME");
	      	InputFilter[] filterArray = new InputFilter[1];
        	filterArray[0] = new InputFilter.LengthFilter(10);
        	input.setFilters(filterArray);
        new AlertDialog.Builder(this)
          .setIcon(R.drawable.sad)
          .setTitle("ALERT")
          .setMessage("Are you sure you want lose this game?")
          .setView(input)
          .setNegativeButton("Return", null)//without listener
          .setPositiveButton("Quit", new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
				            @Override
				            public void onClick(DialogInterface dialog, int which){
				              //exit
				            	if(input.getText().toString() == "")
				            		name="UNKNOWN";
				            	else
				            		name=input.getText().toString();
				            	helper.insertReg(name, record);
				            	helper.closeDB();
				            	record=0;
				            	Intent intent = new Intent(StartNext.this,Score.class);
			        			startActivity(intent);
				            	StartNext.this.finish();
				            }
				          })
          .show();
        //if the listener returns true, means event is processing, and nobody can't do anything
        return true;
      }
      //para las demas cosas, se reenvia el evento al listener habitual
       return super.onKeyDown(keyCode, event);
    }

}
