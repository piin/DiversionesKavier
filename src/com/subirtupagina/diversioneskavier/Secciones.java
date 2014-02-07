package com.subirtupagina.diversioneskavier;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.subirtupagina.diversioneskavier.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;



public class Secciones extends Activity {
	private ImageLoader imageLoader;
	private String urlImagen,url;
	private ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// delete bar title
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secciones);		
		image = (ImageView)findViewById(R.id.imgSecciones);
		
		//valores obtenidos del primer activity
		urlImagen = getIntent().getStringExtra("urlImagen");
		url = getIntent().getStringExtra("url");
		
		mostrarImagen();
		
		image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				Secciones.this.startActivity(intent);
				
			}
		});
		

	}
		
	  private  void mostrarImagen() {
					
			// Get singletone instance of ImageLoader
			imageLoader = ImageLoader.getInstance();
			// Initialize ImageLoader with configuration. Do it once.
			imageLoader.init(ImageLoaderConfiguration.createDefault(this));
			// Load and display image asynchronously			 
			 DisplayImageOptions options = new DisplayImageOptions.Builder().delayBeforeLoading(0)
			 .cacheInMemory(true).cacheOnDisc(true).build();			
			 //Carga imagen de url a ImageView
			imageLoader.displayImage(urlImagen, image, options);	
	}


	
	  @Override   
	  public void onConfigurationChanged(Configuration newConfig) { 
	      super.onConfigurationChanged(newConfig); 
	  } 
	  
	  //tecla atras
	  public boolean onKeyDown(int keyCode, KeyEvent event) {
	   	  
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
			//Limpia memoria cache del disco			
			imageLoader.clearDiscCache();
	    }
	    return super.onKeyDown(keyCode, event);
	  }

}
