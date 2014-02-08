package com.example.hangman;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {
	private Context pContext;
	private SoundPool sndPool;
	private float rate = 1.0f;
	private float leftVolume = 1.0f;
	private float rightVolume = 1.0f;
    public SoundManager(Context appContext){
  	  sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 100);
   	  pContext = appContext;
  }
    public int load(int sound_id){
    	return sndPool.load(pContext, sound_id, 1);
    }
     
    public void play(int sound_id){
    	sndPool.play(sound_id, leftVolume, rightVolume, 1, 0, rate);
    }
    public void unloadAll(){
    	sndPool.release();
    }
    public void pause(int sound_id){
    	sndPool.pause(sound_id);
    }
    public void loop(int sound_id){
    	sndPool.setLoop(sound_id, -1);
    }
}
