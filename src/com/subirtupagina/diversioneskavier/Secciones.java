package com.subirtupagina.diversioneskavier;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.proyectosimio.proyectosimio.R;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;

public class Secciones extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secciones);
		
		String urlImagen = getIntent().getStringExtra("urlImagen");
		System.out.println(urlImagen+"2");
		
		//String image_url = "http://promoandroid.com/usuarios/kavier/imagenes/imagen.png";
		ImageView image = (ImageView) findViewById(R.id.imgSecciones);
		
		// Get singletone instance of ImageLoader
		ImageLoader imageLoader = ImageLoader.getInstance();
		// Initialize ImageLoader with configuration. Do it once.
		imageLoader.init(ImageLoaderConfiguration.createDefault(this));
		// Load and display image asynchronously
		 
		 DisplayImageOptions options = new DisplayImageOptions.Builder()
		 .delayBeforeLoading(0)
		 /*.cacheInMemory(true)
         .cacheOnDisc(true)*/
		 .build();
		 
		 
		imageLoader.displayImage(urlImagen, image, options);
	}
	  @Override 
	  public void onConfigurationChanged(Configuration newConfig) { 
	      super.onConfigurationChanged(newConfig); 
	  } 
	

}
